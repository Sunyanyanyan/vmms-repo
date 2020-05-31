package com.zckj.vmms.vmms.controller;

import com.zckj.vmms.utils.FileUploadUtil;
import com.zckj.vmms.utils.R;
import com.zckj.vmms.vmms.entity.OrderEntity;
import com.zckj.vmms.vmms.service.OrderService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;


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
public class OrderController {
    @Autowired
    private OrderService orderService;


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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "attribute", value = "维修性质", dataType = "String", required = true),
            @ApiImplicitParam(name = "description", value = "故障描述", dataType = "String")
    })
    public R saveOrder(@RequestParam String attribute, @RequestParam(required = false) String description) {

        int result = orderService.saveOrder(attribute, description);
        if (result > 0) {
            return R.ok("申请成功");
        }
        return R.error("申请失败");
    }

//    /**
//     * 保存
//     */
//    @PostMapping(value = "/save", produces = {"application/json;charset=UTF-8"})
//    @ApiOperation(value = "添加工单", notes = "以实体类为参数")
//    public R saveOrder(@RequestBody OrderEntity order) {
//        orderService.save(order);
//
//        return R.ok();
//    }

    /**
     * 修改
     */
    @PutMapping(value = "/update", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "根据工单id更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "主键编号", dataType = "Integer", required = true),
//            @ApiImplicitParam(name = "shopId", value = "维修厂编号", dataType = "Integer"),
//            @ApiImplicitParam(name = "carId", value = "车牌号", dataType = "String"),
//            @ApiImplicitParam(name = "regionNumber", value = "车辆所属单位编号", dataType = "String"),
//            @ApiImplicitParam(name = "applicationTime", value = "申请时间", dataType = "String"),
            @ApiImplicitParam(name = "name", value = "申请人姓名", dataType = "String"),
            @ApiImplicitParam(name = "applicantNumber", value = "申请人编号", dataType = "String"),
//            @ApiImplicitParam(name = "status", value = "状态[待审批；不同意；待修理；修理中；修理完成]", dataType = "String"),
//            @ApiImplicitParam(name = "attribute", value = "维修性质", dataType = "String"),
//            @ApiImplicitParam(name = "beforeImgUrl", value = "维修前照片", dataType = "String"),
//            @ApiImplicitParam(name = "afterImgUrl", value = "维修后照片", dataType = "String"),
//            @ApiImplicitParam(name = "damageImgUrl", value = "损坏件照片", dataType = "String"),
//            @ApiImplicitParam(name = "description", value = "故障描述（非必填）", dataType = "String"),
//            @ApiImplicitParam(name = "startTime", value = "维修开始时间", dataType = "String"),
//            @ApiImplicitParam(name = "endTime", value = "维修结束时间", dataType = "String"),
//            @ApiImplicitParam(name = "exportStatus", value = "导出标志[0-未导出；1-导出]", dataType = "Integer"),
//            @ApiImplicitParam(name = "longitude", value = "经度", dataType = "BigDecimal"),
//            @ApiImplicitParam(name = "latitude", value = "纬度", dataType = "BigDecimal")
    })
    public R updateOrder(OrderEntity order) {
        boolean flag = orderService.updateById(order);
        if (flag) {
            return R.ok("更新成功");
        }

        return R.error("更新失败");
    }

    /**
     * 图片上传
     * @param orderId   主键编号
     * @param beforeImg 维修前照片
     * @param damageImg 损坏件照片
     * @param afterImg  维修后照片
     * @return
     */
    @ApiOperation(value = "图片上传")
    @PostMapping(value = "/upload", produces = "application/json;charset=UTF-8")
    public R uploadImg(
            @ApiParam(name = "orderId", value = "主键编号") @RequestParam(value = "orderId") Integer orderId,
            @ApiParam(name = "beforeImg", value = "维修前照片") @RequestParam(value = "beforeImg", required = false) MultipartFile beforeImg,
            @ApiParam(name = "damageImg", value = "损坏件照片") @RequestParam(value = "damageImg", required = false) MultipartFile damageImg,
            @ApiParam(name = "afterImg", value = "维修后照片") @RequestParam(value = "afterImg",required = false) MultipartFile afterImg) {


        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderId(orderId);

        //获取上传文件路径，并将路径存入数据库表
        if (beforeImg != null) {
            String beforeImgUrl = FileUploadUtil.uploadFile(beforeImg);
            orderEntity.setBeforeImgUrl(beforeImgUrl);
            orderEntity.setStatus("待修理");
            orderService.updateById(orderEntity);
            return R.ok().put("beforeImgUrl", beforeImgUrl);
        }
        if (damageImg != null) {
            String damageImgUrl = FileUploadUtil.uploadFile(damageImg);
            orderEntity.setDamageImgUrl(damageImgUrl);
            orderEntity.setStatus("修理中");
            orderService.updateById(orderEntity);
            return R.ok().put("damageImgUrl", damageImgUrl);
        }
        if (afterImg != null) {
            String afterImgUrl = FileUploadUtil.uploadFile(afterImg);
            orderEntity.setAfterImgUrl(afterImgUrl);
            orderEntity.setStatus("修理完成");
            orderService.updateById(orderEntity);
            return R.ok().put("afterImgUrl", afterImgUrl);
        }
        return R.error("未上传图片");
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R deleteOrder(@RequestBody Integer[] orderIds) {
        orderService.removeByIds(Arrays.asList(orderIds));

        return R.ok();
    }


//    @PutMapping("uploadImg")
//    public R uploadjdt(@RequestParam("pic") MultipartFile[] multipartFile, String picture) {
//        orderService.uploadImg(multipartFile,picture);
//        return result;
//    }

}
