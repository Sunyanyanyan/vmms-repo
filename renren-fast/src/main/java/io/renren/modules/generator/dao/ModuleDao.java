package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.ModuleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 模块
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
@Mapper
public interface ModuleDao extends BaseMapper<ModuleEntity> {

    /**
     * 获取不包含按钮的菜单列表
     */
    List<ModuleEntity> queryNotButtonList();

    /**
     * 功能模块维护-查询最大moduleid+1
     */
    public int maxModuleID();

    void insertModule(ModuleEntity module);
}
