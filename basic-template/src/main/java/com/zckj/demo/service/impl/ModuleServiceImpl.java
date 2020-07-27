package com.zckj.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.common.utils.PageUtils;
import com.zckj.common.utils.Query;

import com.zckj.demo.dao.ModuleDao;
import com.zckj.demo.entity.ModuleEntity;
import com.zckj.demo.service.ModuleService;


@Service("moduleService")
public class ModuleServiceImpl extends ServiceImpl<ModuleDao, ModuleEntity> implements ModuleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ModuleEntity> page = this.page(
                new Query<ModuleEntity>().getPage(params),
                new QueryWrapper<ModuleEntity>()
        );

        return new PageUtils(page);
    }

}