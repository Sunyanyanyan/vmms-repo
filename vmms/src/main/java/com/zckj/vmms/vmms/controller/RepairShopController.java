package com.zckj.vmms.vmms.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zckj.vmms.vmms.entity.RepairShopEntity;
import com.zckj.vmms.vmms.service.RepairShopService;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.R;



/**
 * 维修厂单表
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
@RestController
@RequestMapping("vmms/repairshop")
@Api(tags ="维修厂单接口")
public class RepairShopController {
    @Autowired
    private RepairShopService repairShopService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam(required = false) Map<String, Object> params){
        PageUtils page = repairShopService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{shopId}")
    public R info(@PathVariable("shopId") Integer shopId){
		RepairShopEntity repairShop = repairShopService.getById(shopId);

        return R.ok().put("repairShop", repairShop);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody RepairShopEntity repairShop){
		repairShopService.save(repairShop);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody RepairShopEntity repairShop){
		repairShopService.updateById(repairShop);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Integer[] shopIds){
		repairShopService.removeByIds(Arrays.asList(shopIds));

        return R.ok();
    }

}
