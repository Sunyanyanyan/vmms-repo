package com.zckj.demo.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zckj.demo.entity.XlxxEntity;
import com.zckj.demo.service.XlxxService;
import com.zckj.common.utils.PageUtils;
import com.zckj.common.utils.R;



/**
 * ${comments}
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-10 20:14:06
 */
@RestController
@RequestMapping("demo/xlxx")
public class XlxxController {
    @Autowired
    private XlxxService xlxxService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = xlxxService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tgOrgNo}")
    public R info(@PathVariable("tgOrgNo") String tgOrgNo){
		XlxxEntity xlxx = xlxxService.getById(tgOrgNo);

        return R.ok().put("xlxx", xlxx);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XlxxEntity xlxx){
		xlxxService.save(xlxx);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XlxxEntity xlxx){
		xlxxService.updateById(xlxx);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] tgOrgNos){
		xlxxService.removeByIds(Arrays.asList(tgOrgNos));

        return R.ok();
    }

}
