package com.zckj.vmms.vmms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zckj.vmms.utils.FileUploadUtil;
import com.zckj.vmms.utils.R;
import com.zckj.vmms.utils.ZipUtils;
import com.zckj.vmms.vmms.entity.OrderEntity;
import com.zckj.vmms.vmms.service.OrderService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * 维修工单
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
@RestController
@RequestMapping("vmms/order")
@Api(tags = "工单接口")
@Slf4j
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    protected HttpServletResponse response;

    /**
     * 所有工单列表
     */
    @ApiOperation(value = "所有工单列表")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public R listOrder() {
        List<OrderEntity> list = orderService.list(null);
        return R.ok().put("list", list);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{orderId}")
    public R infoOrder(@PathVariable("orderId") Integer orderId) {
        OrderEntity order = orderService.getById(orderId);

        return R.ok().put("order", order);
    }

    /**
     * 维修申请
     */
    @PostMapping(value = "/save", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "维修申请")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "repairNature", value = "维修性质[保养、维修、装饰、其他]", dataType = "String", required = true),
//            @ApiImplicitParam(name = "repairDesc", value = "故障描述", dataType = "String"),
//            @ApiImplicitParam(name = "applicantId", value = "申请人编号", dataType = "String")
//    })
    @ApiImplicitParam(name = "repairNature", value = "维修性质[保养、维修、装饰、其他]", required = true)
    public R saveOrder(OrderEntity orderEntity) {

        int result = orderService.saveOrder(orderEntity);
        if (result > 0) {
            return R.ok("申请成功");
        }
        return R.error("申请失败");
    }

    /**
     * 修改
     */
    @PutMapping(value = "/update", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "根据主键编号orderId更新")
    @ApiImplicitParam(name = "orderId", value = "主键编号", required = true)
    public R updateOrder(OrderEntity order) {
        boolean flag = orderService.updateById(order);
        if (flag) {
            return R.ok().put("更新成功", true);
        }
        return R.error("更新失败");
    }

    @ApiOperation("根据申请人编号查询工单信息")
    @GetMapping("/find/{applicationId}")
    public R findByApplicantId(@ApiParam(name = "applicationId", value = "申请人编号", required = true) @PathVariable(value = "applicationId") String applicationId) {
        QueryWrapper<OrderEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("applicant_id", applicationId);
        List<OrderEntity> list = orderService.list(queryWrapper);
        if (list.size() > 0) {
            return R.ok().put("list", list);
        }
        return R.error("查询信息不存在");
    }

    /**
     * 图片上传
     *
     * @param orderId   主键编号
     * @param beforeImg 维修前照片
     * @param damageImg 损坏件照片
     * @param afterImg  维修后照片
     */
    @ApiOperation(value = "图片上传")
    @PostMapping(value = "/upload", produces = "application/json;charset=UTF-8")
    public R uploadImg(
            @ApiParam(name = "orderId", value = "主键编号", required = true) @RequestParam(value = "orderId") Integer orderId,
            @ApiParam(name = "beforeImg", value = "维修前照片") @RequestParam(value = "beforeImg", required = false) MultipartFile beforeImg,
            @ApiParam(name = "damageImg", value = "损坏件照片") @RequestParam(value = "damageImg", required = false) MultipartFile damageImg,
            @ApiParam(name = "afterImg", value = "维修后照片") @RequestParam(value = "afterImg", required = false) MultipartFile afterImg) {

        R returnR = R.ok();

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderId(orderId);

        //获取上传文件路径，并将路径存入数据库表
        String beforeImgUrl = null;
        String damageImgUrl = null;
        String afterImgUrl = null;

        if (beforeImg != null) {
            beforeImgUrl = FileUploadUtil.uploadFile(beforeImg);
            orderEntity.setBeforeImgUrl(beforeImgUrl);
            orderService.updateById(orderEntity);
            returnR.put("beforeImgUrl", beforeImgUrl);
        }
        if (damageImg != null) {
            damageImgUrl = FileUploadUtil.uploadFile(damageImg);
            orderEntity.setDamageImgUrl(damageImgUrl);
            orderService.updateById(orderEntity);
            returnR.put("damageImgUrl", damageImgUrl);
        }
        if (afterImg != null) {
            afterImgUrl = FileUploadUtil.uploadFile(afterImg);
            orderEntity.setAfterImgUrl(afterImgUrl);
            orderService.updateById(orderEntity);
            returnR.put("afterImgUrl", afterImgUrl);
        }
        return returnR;
    }

    /**
     * 图片批量下载
     *
     * @param
     * @param response
     * @return
     * @throws IOException
     */
    //多个文件，压缩成zip后下载
    @GetMapping("downloadImg")
    @ApiOperation(value = "图片下载")
    public R downloadMoreFile(HttpServletRequest request, HttpServletResponse response) {

        String temporaryPath = "D:/fileUploadTemp/";  //本地路径
//        String temporaryPath = "/usr/imagesTemp/";    //服务器路径
        /**
         * 1.创建临时文件夹
         */
        File tempDir = new File(temporaryPath);
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }

        /**
         * 项目文件存放地址
         */
        String fileUrl = ("D:/fileUpload/");  //本地路径
//        String fileUrl = ("/usr/images/");  //服务器路径

        /**
         * 2.生成需要下载的文件，存放在临时文件夹内
         */
        try {
            ZipUtils.copyDir(fileUrl, temporaryPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 3.设置response的header
         */
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=repairImg.zip");

        /**
         * 4.调用工具类，下载zip压缩包
         */
        try {
            ZipUtils.toZip(tempDir.getPath(), response.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * 5.删除临时文件和文件夹
         */
        File[] listFiles = tempDir.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            listFiles[i].delete();
            log.info("正在删除第" + i + "个文件");
        }
        tempDir.delete();
        return null;
    }

/**
 * 删除
 */
//    @DeleteMapping("/delete")
//    public R deleteOrder(@RequestBody Integer[] orderIds) {
//        orderService.removeByIds(Arrays.asList(orderIds));
//
//        return R.ok();
//    }

}
