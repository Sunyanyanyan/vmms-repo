package com.zckj.vmms.vmms.controller;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zckj.vmms.vmms.entity.CarEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zckj.vmms.vmms.entity.RepairShopEntity;
import com.zckj.vmms.vmms.service.RepairShopService;
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
    public R listRepairShop(){
        List<RepairShopEntity> list = repairShopService.list(null);

        return R.ok().put("list", list);
    }
    /**
     * 根据单位编号查询
     */
    @GetMapping("/findByRegionNumber")
    @ApiOperation(value = "根据单位编号regionNumber查询")
    @ApiImplicitParam(name = "regionNumber", value = "单位编号", required = true)
    public R findByRegionNumber(RepairShopEntity repairShopEntity) {
        String regionNumber = repairShopEntity.getRegionNumber();
        QueryWrapper<RepairShopEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("region_number",regionNumber);
        List<RepairShopEntity> list = repairShopService.list(queryWrapper);
        if (list.size()>0) {
            return R.ok().put("list",list);
        }
        return R.error("查询信息不存在");
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
    public R save(RepairShopEntity repairShop){
		repairShopService.save(repairShop);

        return R.ok();
    }
//
//    /**
//     * 修改
//     */
//    @PutMapping("/update")
//    public R update(@RequestBody RepairShopEntity repairShop){
//		repairShopService.updateById(repairShop);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @DeleteMapping("/delete")
//    public R delete(@RequestBody Integer[] shopIds){
//		repairShopService.removeByIds(Arrays.asList(shopIds));
//
//        return R.ok();
//    }

}
