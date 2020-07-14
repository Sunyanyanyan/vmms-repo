package com.zckj.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zckj.sys.entity.Module;
import com.zckj.sys.entity.Role;
import com.zckj.sys.mapper.ModuleMapper;
import com.zckj.sys.service.ModuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.sys.utils.PageUtils;
import com.zckj.sys.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements ModuleService {
    @Autowired
    public ModuleMapper moduleMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Module> page = this.page(
                new Query<Module>().getPage(params),
                new QueryWrapper<Module>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertModule(Module module) {

        try {
            module.setModuleid(moduleMapper.maxModuleID());
            moduleMapper.insertModule(module);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Module> listModule(Role role) {
        List<Module> module = moduleMapper.listModule(role);
        return module;
    }
}
