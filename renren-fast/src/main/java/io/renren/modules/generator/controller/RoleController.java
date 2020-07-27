package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.Constant;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.generator.entity.RoleEntity;
import io.renren.modules.generator.service.RoleService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 岗位角色
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
@RestController
@RequestMapping("/generator/role")
public class RoleController extends AbstractController {
    @Autowired
    private RoleService roleService;

    /**
     * 角色列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("sys:role:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = roleService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 角色列表
     * @return
     */
    @GetMapping("/select")
//    @RequiresPermissions("sys:role:select")
    public R  selectRole() {
        Map<String, Object> map = new HashMap<>();
//        if (Long.parseLong(getWorkerId()) != Constant.SUPER_ADMIN) {
//            map.put("create_user_id", getWorkerId());
//        }
        List<RoleEntity> list = roleService.listByMap(map);

        return R.ok().put("list", list);
    }

    /**
     * 角色信息
     */
    @RequestMapping("/info/{roleid}")
    public R info(@PathVariable("roleid") String roleid){
		RoleEntity role = roleService.getById(roleid);

        return R.ok().put("role", role);
    }

    /**
     * 保存角色
     */
    @SysLog("保存角色")
    @PostMapping("/save")
    @RequiresPermissions("sys:role:save")
    public R save(@RequestBody RoleEntity role){
//        ValidatorUtils.validateEntity(role);
		roleService.save(role);

        return R.ok();
    }

    /**
     * 修改角色
     */
    @SysLog("修改角色")
    @PostMapping("/update")
    public R update(@RequestBody RoleEntity role){
//        ValidatorUtils.validateEntity(role);
		roleService.updateById(role);

        return R.ok();
    }

    /**
     * 删除角色
     */
    @SysLog("删除角色")
    @PostMapping("/delete")
//    @RequiresPermissions("sys:role:delete")
    public R delete(@RequestBody String[] roleids){
        roleService.removeByIds(Arrays.asList(roleids));

        return R.ok();
    }

}
