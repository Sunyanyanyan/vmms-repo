package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.sys.entity.SysMenuEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.generator.entity.OrgEntity;
import io.renren.modules.generator.service.OrgService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * ORG
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
@RestController
@RequestMapping("generator/org")
@CrossOrigin
@Slf4j
public class OrgController {
    @Autowired
    private OrgService orgService;


    /**
     * 查出所有分类以及子分类，以树形结构组装起来
     */
    @RequestMapping("/list/tree")
    public R list(){
        log.info("---------tree-------");
        List<OrgEntity> entities = orgService.listWithTree();

        return R.ok().put("data",entities);
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
     * RequestBody:获取请求体，必须发送POST请求
     */
    @PostMapping("/delete")
    public R delete(@RequestBody String[] orgnos){

        // 1、检查当前删除的菜单，是否被别的地方引用
//		orgService.removeByIds(Arrays.asList(orgnos));
		orgService.removeMenuByIds(Arrays.asList(orgnos));

        return R.ok();
    }

}
