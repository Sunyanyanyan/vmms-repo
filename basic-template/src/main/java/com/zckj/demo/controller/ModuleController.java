package com.zckj.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zckj.demo.entity.ModuleEntity;
import com.zckj.demo.service.ModuleService;
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
@RequestMapping("demo/module")
@Api
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    /**
     * 列表
     */
    @ApiOperation("list")
    @RequestMapping("/listModule")
    public R listModule(){
        List<ModuleEntity> page = moduleService.list();

        return R.ok().put("page", page);
    }

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = moduleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{moduleid}")
    public R info(@PathVariable("moduleid") Integer moduleid){
		ModuleEntity module = moduleService.getById(moduleid);

        return R.ok().put("module", module);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ModuleEntity module){
		moduleService.save(module);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ModuleEntity module){
		moduleService.updateById(module);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] moduleids){
		moduleService.removeByIds(Arrays.asList(moduleids));

        return R.ok();
    }

}
