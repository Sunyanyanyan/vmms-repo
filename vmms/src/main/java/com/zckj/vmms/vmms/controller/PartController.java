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

import com.zckj.vmms.vmms.entity.PartEntity;
import com.zckj.vmms.vmms.service.PartService;



/**
 * 备件
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-22 16:42:59
 */
@RestController
@RequestMapping("vmms/part")
public class PartController {
    @Autowired
    private PartService partService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = partService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{partId}")
    public R info(@PathVariable("partId") String partId){
		PartEntity part = partService.getById(partId);

        return R.ok().put("part", part);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PartEntity part){
		partService.save(part);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PartEntity part){
		partService.updateById(part);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] partIds){
		partService.removeByIds(Arrays.asList(partIds));

        return R.ok();
    }

}
