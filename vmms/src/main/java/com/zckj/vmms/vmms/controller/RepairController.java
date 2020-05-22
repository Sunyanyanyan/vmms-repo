package com.zckj.vmms.vmms.controller;

import java.util.Arrays;
import java.util.Map;

import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zckj.vmms.vmms.entity.RepairEntity;
import com.zckj.vmms.vmms.service.RepairService;



/**
 * 维修订单
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-22 16:42:59
 */
@RestController
@RequestMapping("vmms/repair")
public class RepairController {
    @Autowired
    private RepairService repairService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = repairService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{repairId}")
    public R info(@PathVariable("repairId") String repairId){
		RepairEntity repair = repairService.getById(repairId);

        return R.ok().put("repair", repair);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RepairEntity repair){
		repairService.save(repair);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RepairEntity repair){
		repairService.updateById(repair);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] repairIds){
		repairService.removeByIds(Arrays.asList(repairIds));

        return R.ok();
    }

}
