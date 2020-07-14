package com.zckj.sys.controller;


import com.zckj.sys.common.R;
import com.zckj.sys.entity.Role;
import com.zckj.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 登录-查询当前操作员的所有岗位
     *
     * @param roleid
     * @param grade
     * @return
     */
    @GetMapping("/list")
    public R list(Role role) {
        List<Role> roles = roleService.getRole(role);

        return R.ok().data("list", roles);
    }

    /**
     * 根据grade查询
     */
    @GetMapping("/listRole")
    public R listRole(Integer grade) {
        List<Role> list = roleService.listRole(grade);
        return R.ok().data("list", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{roleid}")
    public R info(@PathVariable("roleid") String roleid) {
        Role role = roleService.getById(roleid);

        return R.ok().data("role", role);
    }

    /**
     * 岗位设置--插入
     *
     * @param Role类：Roleid+moduleid为主键
     * @return roleid
     *
     */
    @PostMapping("/save")
    public R saveRole(@RequestBody Role role) {
        String roleId = roleService.insertRole(role);

        return R.ok().data("roleid", roleId);
    }
    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody Role role){
        roleService.updateById(role);

        return R.ok();
    }

    /**
     * 岗位设置-删除岗位
     *
     * @param roleid,grade
     */
    @PostMapping("/delete")
    public R deleteRole(@RequestBody Role role) {
        Boolean flag = roleService.deleteRole(role);
        if (flag) {
            return R.ok();
        }
        return R.error();
    }

}

