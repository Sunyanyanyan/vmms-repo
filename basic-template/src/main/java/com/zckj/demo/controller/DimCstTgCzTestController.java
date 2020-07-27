package com.zckj.demo.controller;

import java.util.Arrays;
import java.util.Map;

import com.zckj.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zckj.demo.entity.DimCstTgCzTestEntity;
import com.zckj.demo.service.DimCstTgCzTestService;
import com.zckj.common.utils.PageUtils;




/**
 * ${comments}
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-10 20:14:07
 */
@RestController
@RequestMapping("demo/dimcsttgcztest")
public class DimCstTgCzTestController {
    @Autowired
    private DimCstTgCzTestService dimCstTgCzTestService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dimCstTgCzTestService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tgId}")
    public R info(@PathVariable("tgId") String tgId){
		DimCstTgCzTestEntity dimCstTgCzTest = dimCstTgCzTestService.getById(tgId);

        return R.ok().put("dimCstTgCzTest", dimCstTgCzTest);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DimCstTgCzTestEntity dimCstTgCzTest){
		dimCstTgCzTestService.save(dimCstTgCzTest);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DimCstTgCzTestEntity dimCstTgCzTest){
		dimCstTgCzTestService.updateById(dimCstTgCzTest);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] tgIds){
		dimCstTgCzTestService.removeByIds(Arrays.asList(tgIds));

        return R.ok();
    }

}
