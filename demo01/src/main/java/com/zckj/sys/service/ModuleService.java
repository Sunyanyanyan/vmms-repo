package com.zckj.sys.service;

import com.zckj.sys.entity.Module;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zckj.sys.entity.Role;
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
public interface ModuleService extends IService<Module> {
    PageUtils queryPage(Map<String, Object> params);

    void insertModule(Module module);

    /**
     * 界面菜单显示-根据操作员所属单位等级查询指定岗位的功能模块
     *
     * @param roleid 岗位编号
     * @param grade 单位等级
     */
    List<Module> listModule(Role role);
}
