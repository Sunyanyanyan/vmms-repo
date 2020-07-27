package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.ModuleEntity;
import io.renren.modules.generator.entity.RoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 岗位角色
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
@Mapper
public interface RoleDao extends BaseMapper<RoleEntity> {


    /**
     * 界面菜单显示-根据操作员所属单位等级查询指定岗位的功能模块
     * @param roleid 岗位编号
     * @param grade 单位等级
     */
    List<ModuleEntity> listModule(RoleEntity Role);

    /**
     * 根据角色ID，获取模块ID列表
     */
    List<String> queryMenuIdList(String roleId);

    /**
     * 根据角色ID数组，批量删除
     */
    int deleteBatch(String[] roleIds);
}
