package com.zckj.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zckj.sys.entity.Role;
import com.zckj.sys.mapper.RoleMapper;
import com.zckj.sys.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.sys.utils.PageUtils;
import com.zckj.sys.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Role> page = this.page(
                new Query<Role>().getPage(params),
                new QueryWrapper<Role>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Role> getRole(Role role) {
        List<Role> roles = roleMapper.getRole(role);
        return roles;
    }

    @Override
    public List<Role> listRole(Integer grade) {
        return roleMapper.listRole(grade);
    }

    @Override
    public String insertRole(Role role) {
        String roleid = role.getRoleid();
        if (roleid.equals("0")) {
            roleid = roleMapper.maxRoleId(role.getGrade());
            role.setOrdid(Integer.parseInt(role.getRoleid()));
        }

        // 获取新的模块编号
        String moduleid = String.valueOf(role.getModuleid());
        String[] s = moduleid.split(",");
        // 将新的岗位与模块编号合并一条数据
        for (int i = 0; i < s.length; i++) {
            Role r = new Role();
            r.setRoleid(roleid);
            r.setModuleid(Integer.parseInt(s[i]));
            r.setOrdid(role.getOrdid());
            r.setRolename(role.getRolename());
            r.setGrade(role.getGrade());
            roleMapper.insertRole(r);
        }

        // 返回roleid
        return roleid;
    }

    @Override
    public Boolean deleteRole(Role role) {
        return roleMapper.deleteRole(role);
    }

}
