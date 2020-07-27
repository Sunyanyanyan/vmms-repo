package io.renren.modules.generator.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.modules.generator.entity.ModuleEntity;
import io.renren.modules.generator.entity.RoleEntity;
import io.renren.modules.generator.service.ModuleService;
import io.renren.modules.generator.service.RoleService;
import io.renren.modules.sys.controller.AbstractController;
import io.renren.modules.sys.entity.SysMenuEntity;
import io.renren.modules.sys.service.ShiroService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


/**
 * 模块菜单
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
@RestController
@RequestMapping("/generator/module")
@Slf4j
public class ModuleController extends AbstractController {
    @Autowired
    private ModuleService moduleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ShiroService shiroService;

    /**
     * 导航菜单
     */
    @GetMapping("/nav")
    public R nav() {
        List<ModuleEntity> menuList= moduleService.getWorkerMenuList(getWorkerId());
        Set<String> permissions = shiroService.getWorkerPermissions(getWorkerId());
        return R.ok().put("menuList", menuList).put("permissions", permissions);
    }
    /**
     * 所有菜单列表
     *
     */
    @GetMapping("/list")
//    @RequiresPermissions("sys:menu:list")
    public List<ModuleEntity> list() {
        QueryWrapper<ModuleEntity> queryWrapper = new QueryWrapper<>();
        // ROLE表
        List<RoleEntity> roleEntityList = roleService.list();
        List<ModuleEntity> moduleEntityList = null;
        for (RoleEntity roleEntity : roleEntityList) {
            // 角色名称，如：系统管理
            String rolename = roleEntity.getRolename();
            // 模块列表
            moduleEntityList = moduleService.list();
            for (ModuleEntity moduleEntity : moduleEntityList) {
                // 模块列表父菜单名字，如：系统管理，查询分析...
                String parent = moduleEntity.getParent();
                // 判断模块父菜单名和角色名称是否相同
                if (parent.equals(rolename)) {
                    // 拼接sql，根据父菜单名查询模块列表
                    queryWrapper.select("PARENT", parent);
                    moduleEntityList = moduleService.list(queryWrapper);
                    // 父菜单
//                    for (ModuleEntity parentMenuEntity : moduleEntityList) {
//                        if (parentMenuEntity != null) {
//                            moduleEntity.setParent(parentMenuEntity.getParent());
//                        }
//                    }
                }
            }

        }

        return moduleEntityList;
    }

    /**
     * 选择菜单(添加、修改菜单)
     */
    @GetMapping("/select")
//    @RequiresPermissions("sys:menu:select")
    public R selectModule() {

        // 查询列表数据
        List<ModuleEntity> menuList = moduleService.list();

        return R.ok().put("menuList", menuList);
    }
    /**
     * 菜单信息
     */
//    @GetMapping("/info/{menuId}")
////    @RequiresPermissions("sys:menu:info")
//    public R info(@PathVariable("menuId") String menuId){
//        ModuleEntity menu = moduleService.getById(menuId);
//        return R.ok().put("menu", menu);
//    }

    /**
     * 删除
     */
    @SysLog("删除菜单")
    @PostMapping("/delete/{menuId}")
    @RequiresPermissions("sys:menu:delete")
    public R delete(@PathVariable("menuId") String menuId){
//        if(menuId <= 31){
//            return R.error("系统菜单，不能删除");
//        }

        //判断是否有子菜单或按钮
        List<ModuleEntity> menuList = moduleService.queryListParent(menuId);
        if(menuList.size() > 0){
            return R.error("请先删除子菜单或按钮");
        }

        moduleService.delete(menuId);

        return R.ok();
    }



    /**
     * 功能模块维护-根据等级查询功能模块信息
     *
     * @param grade 单位等级
     * @return 返回功能模块列表
     */
    @GetMapping("/queryModule")
    public R queryModuleByGrade(@RequestParam int grade) {

        // MyBatisPlus条件构造器带条件排序
        QueryWrapper<ModuleEntity> queryWrapper = new QueryWrapper<ModuleEntity>();
        queryWrapper.eq("GRADE", grade).orderByAsc("ORDID"); // orderByAsc: 升序

        List<ModuleEntity> list = moduleService.list(queryWrapper);
        log.info("------list------" + list);

        return R.ok().put("data", list);

    }

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params) {
//        PageUtils page = moduleService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


    /**
     * 信息
     */
    @RequestMapping("/info/{moduleid}")
    public R info(@PathVariable("moduleid") int moduleid) {
        ModuleEntity module = moduleService.getById(moduleid);

        return R.ok().put("module", module);
    }

    /**
     * 功能模块维护-添加功能模块信息
     */
    @PostMapping("/save")
    public R insertModule(@RequestBody ModuleEntity module) {
        moduleService.insertModule(module);

        return R.ok().put("moduleid",module.getModuleid()); // 返回moduleid
    }

    /**
     * 功能模块维护-修改功能模块信息
     */
    @RequestMapping("/update")
    public R update(@RequestBody ModuleEntity module) {
        moduleService.updateById(module);

        return R.ok();
    }

    /**
     * 删除
     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Integer[] moduleids) {
//        moduleService.removeByIds(Arrays.asList(moduleids));
//
//        return R.ok();
//    }

}
