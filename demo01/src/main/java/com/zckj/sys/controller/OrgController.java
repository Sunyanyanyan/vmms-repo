package com.zckj.sys.controller;


import com.zckj.sys.common.R;
import com.zckj.sys.entity.Org;
import com.zckj.sys.service.OrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
@RestController
@RequestMapping("/sys/org")
@Slf4j
public class OrgController {
    @Autowired
    private OrgService orgService;

    /**
     * 查出所有分类以及子分类，以树形结构组装起来
     */
    @GetMapping("/list/tree")
    public R list(){
        log.info("---------tree-------");
        List<Org> entities = orgService.listWithTree();

        return R.ok().data("data",entities);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{orgno}")
    public R info(@PathVariable("orgno") String orgno){
        Org org = orgService.getById(orgno);

        return R.ok().data("org", org);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody Org org){
        orgService.saveOrg(org);
        List<Org> orgs = orgService.listWithTree();
        return R.ok().data("data", orgs);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody Org org){
        orgService.updateById(org);

        return R.ok();
    }

    /**
     * 删除
     * RequestBody:获取请求体，必须发送POST请求
     */
    @PostMapping("/delete")
    public R delete(@RequestBody String[] ids){
        // 1、检查当前删除的菜单，是否被别的地方引用
//        orgService.removeMenuByIds(Arrays.asList(ids));
		orgService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}

