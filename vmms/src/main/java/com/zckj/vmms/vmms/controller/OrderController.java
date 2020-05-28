package com.zckj.vmms.vmms.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.sun.imageio.plugins.common.ImageUtil;
//import com.zckj.vmms.vmms.vo.R;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zckj.vmms.vmms.entity.OrderEntity;
import com.zckj.vmms.vmms.service.OrderService;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.R;
import org.springframework.web.multipart.MultipartFile;


/**
 * 维修工单
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
@RestController
@RequestMapping("vmms/order")
@Api(value = "工单接口")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 所有工单列表
     */
    @ApiOperation(value = "所有工单列表")
    @GetMapping
    public R list(){
        List<OrderEntity> list = orderService.list(null);
        return R.ok().put("items", list);
    }


    /**
     * 维修申请
     */
    @PostMapping(value = "/save/apply", produces = {"application/json;charset=UTF-8"})
    @ApiModelProperty(value = "维修申请")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "attribute", value = "维修性质", dataType = "String", required = true),
            @ApiImplicitParam(name = "description", value = "故障描述", dataType = "String", required = false)
    })
    public R saveApply(@RequestParam(required = true) String attribute, @RequestParam(required = false) String description) {
        orderService.saveApply(attribute, description);
        return R.ok();
    }


    /**
     * 列表
     */
    @GetMapping("/list")
    public R listOrder(@RequestParam Map<String, Object> params) {
        PageUtils page = orderService.queryPage(params);

        return R.ok().put("page", page);
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
     * 保存
     */
    @PostMapping(value = "/save", produces = {"application/json;charset=UTF-8"})
    @ApiModelProperty(value = "添加工单", notes = "以实体类为参数")
    public R saveOrder(@RequestBody OrderEntity order) {
        orderService.save(order);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R updateOrder(@RequestBody OrderEntity order) {
        orderService.updateById(order);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R deleteOrder(@RequestBody Integer[] orderIds) {
        orderService.removeByIds(Arrays.asList(orderIds));

        return R.ok();
    }

}
