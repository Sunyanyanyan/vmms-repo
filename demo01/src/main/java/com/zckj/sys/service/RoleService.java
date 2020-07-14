package com.zckj.sys.service;

import com.zckj.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zckj.sys.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
public interface RoleService extends IService<Role> {
    PageUtils queryPage(Map<String, Object> params);
    /**
     * 返回用户权限,根据操作员所属单位等级查询指定岗位的功能模块
     *
     * @param username
     *            用户权限id
     * @return
     */
    List<Role> getRole(Role role);


    /**
     * 岗位设置-查询指定级别的所有岗位
     *
     * @param grade
     * @return role类
     */
    List<Role> listRole(Integer grade);

    /**
     * 岗位设置--插入
     *
     * @param Role类：Roleid+moduleid为主键
     * @return 成功返回Roleid，失败返回0
     *
     */
    String insertRole(Role role);

    /**
     * 岗位设置-删除岗位
     *
     * @param roleid,grade
     *
     */
    Boolean deleteRole(Role role);
}
