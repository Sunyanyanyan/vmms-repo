package com.zckj.demo.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zckj.demo.entity.OrgEntity;
import com.zckj.demo.service.OrgService;
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
@RequestMapping("demo/org")
public class OrgController {
    @Autowired
    private OrgService orgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orgno}")
    public R info(@PathVariable("orgno") String orgno){
		OrgEntity org = orgService.getById(orgno);

        return R.ok().put("org", org);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OrgEntity org){
		orgService.save(org);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody OrgEntity org){
		orgService.updateById(org);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] orgnos){
		orgService.removeByIds(Arrays.asList(orgnos));

        return R.ok();
    }

}
