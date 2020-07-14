package com.zckj.sys.mapper;

import com.zckj.sys.entity.Module;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zckj.sys.entity.Role;
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
public interface ModuleMapper extends BaseMapper<Module> {
    /**
     * 功能模块维护-查询最大moduleid+1
     */
    int maxModuleID();

    void insertModule(Module module);

    /**
     * 界面菜单显示-根据操作员所属单位等级查询指定岗位的功能模块
     * @param roleid 岗位编号
     * @param grade 单位等级
     */
    List<Module> listModule(Role role);

}
