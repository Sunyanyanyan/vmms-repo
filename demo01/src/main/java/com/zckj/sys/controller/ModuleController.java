package com.zckj.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zckj.sys.common.R;
import com.zckj.sys.entity.Module;
import com.zckj.sys.entity.Role;
import com.zckj.sys.mapper.ModuleMapper;
import com.zckj.sys.service.ModuleService;
import com.zckj.sys.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
@RestController
@RequestMapping("/sys/module")
@Slf4j
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    /**
     * 根据roleid和单位等级grade
     * 查询左侧菜单列表
     *
     * @param roleid
     * @param grade
     */
    @GetMapping("/list")
    public R selectModule(Role role, HttpServletRequest request) {
        String id = request.getSession().getId();
        System.out.println("--------selectModule-----------" + id);
        List<Module> modules = moduleService.listModule(role);

        return R.ok().data("list", modules);
    }

//    }
//    @GetMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = moduleService.queryPage(params);
//
//        return R.ok().data("page", page);
//    }

    /**
     * 功能模块维护-根据等级查询功能模块信息
     *
     * @param grade 单位等级
     * @return 返回功能模块列表
     */
    @GetMapping("/queryModule")
    public R queryModuleByGrade(@RequestParam Integer grade) {
        // MyBatisPlus条件构造器带条件排序
        QueryWrapper<Module> queryWrapper = new QueryWrapper<Module>();
        queryWrapper.eq("GRADE", grade).orderByAsc("ORDID"); // orderByAsc: 升序

        List<Module> list = moduleService.list(queryWrapper);

        return R.ok().data("list", list);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{moduleid}")
    public R info(@PathVariable("moduleid") int moduleid) {
        Module module = moduleService.getById(moduleid);
        log.info("module-----!!----------" + module);
        return R.ok().data("module", module);
    }

    /**
     * 功能模块维护-添加功能模块信息
     */
    @PostMapping("/save")
    public R insertModule(@RequestBody Module module) {
        moduleService.insertModule(module);

        return R.ok().data("moduleid", module.getModuleid()); // 返回moduleid
    }

    /**
     * 功能模块维护-修改功能模块信息
     */
    @PostMapping("/update")
    public R update(@RequestBody Module module) {
        moduleService.updateById(module);

        return R.ok();
    }

    /**
     * 删除
     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Integer[] ids) {
//        System.out.println("moduleides::" + Arrays.asList(ids));
////        moduleService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }
    @DeleteMapping("/delete/{moduleid}")
    public R delete(@PathVariable("moduleid") Integer moduleid) {
        moduleService.removeById(moduleid);

        return R.ok();
    }

}

