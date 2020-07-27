package com.zckj.demo.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zckj.demo.entity.DimEqpLineStandbkCzEntity;
import com.zckj.demo.service.DimEqpLineStandbkCzService;
import com.zckj.common.utils.PageUtils;
import com.zckj.common.utils.R;



/**
 * ${comments}
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-10 20:14:07
 */
@RestController
@RequestMapping("demo/dimeqplinestandbkcz")
public class DimEqpLineStandbkCzController {
    @Autowired
    private DimEqpLineStandbkCzService dimEqpLineStandbkCzService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dimEqpLineStandbkCzService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{linePkId}")
    public R info(@PathVariable("linePkId") String linePkId){
		DimEqpLineStandbkCzEntity dimEqpLineStandbkCz = dimEqpLineStandbkCzService.getById(linePkId);

        return R.ok().put("dimEqpLineStandbkCz", dimEqpLineStandbkCz);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DimEqpLineStandbkCzEntity dimEqpLineStandbkCz){
		dimEqpLineStandbkCzService.save(dimEqpLineStandbkCz);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DimEqpLineStandbkCzEntity dimEqpLineStandbkCz){
		dimEqpLineStandbkCzService.updateById(dimEqpLineStandbkCz);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] linePkIds){
		dimEqpLineStandbkCzService.removeByIds(Arrays.asList(linePkIds));

        return R.ok();
    }

}
