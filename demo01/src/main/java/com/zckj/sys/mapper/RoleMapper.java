package com.zckj.sys.mapper;

import com.zckj.sys.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 登录-查询当前操作员的所有岗位
     * @param roleid
     * @param grade
     * @return
     */
    List<Role> getRole(Role role);

    List<Role> listRole(Integer grade);

    /**
     * 岗位设置-查询指定级别的最大Roleid+1
     *
     * @param grade
     * @return 返回最大Roleid+1
     *
     */
    String maxRoleId(Integer grade);
    /**
     * 岗位设置-岗位role表插入记录
     *
     * @param role

     */
    void insertRole(Role role);

    /**
     * 岗位设置-删除岗位
     *
     * @param roleid,grade
     *
     */
    Boolean deleteRole(Role role);
}
