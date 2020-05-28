package com.zckj.vmms.vmms.controller;

import com.zckj.vmms.utils.FileUploadUtil;
import com.zckj.vmms.utils.R;
import com.zckj.vmms.vmms.entity.OrderEntity;
import com.zckj.vmms.vmms.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Api(tags = "上传图片至云服务器")
@CrossOrigin//跨域
@RestController
@RequestMapping("/vmms/order")
@Slf4j
public class FileUploadController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "上传维修前照片")
    @PostMapping(value = "/list", produces = "application/json;charset=UTF-8")
    public R upLoadAccessory(
            @ApiParam(name = "longitude", value = "经度") @RequestParam(value = "longitude") BigDecimal longitude,
            @ApiParam(name = "latitude", value = "纬度") @RequestParam(value = "latitude") BigDecimal latitude,
            @ApiParam(name = "startTime", value = "维修前照片拍摄时间") @RequestParam(value = "startTime") String startTime,
            @ApiParam(name = "file", value = "维修前照片") @RequestParam("file") MultipartFile file) {
        OrderEntity orderEntity = new OrderEntity();
//        orderEntity.setOrderId(1);
        orderEntity.setLongitude(longitude);
        orderEntity.setLatitude(latitude);
        orderEntity.setStartTime(startTime);

        String url = FileUploadUtil.uploadFile(file);

        //文件URL存入数据库表
        orderEntity.setBeforeImgUrl(url);
        boolean flag = orderService.save(orderEntity);

        if (flag) {
//            Collection<OrderEntity> orderEntities = orderService.list();
            return R.ok().put("添加成功", true);
        } else {
            return R.ok().put("添加失败", null);
        }

    }

}
