package com.zckj.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.common.utils.PageUtils;
import com.zckj.common.utils.Query;

import com.zckj.demo.dao.DimCstTgCzTestDao;
import com.zckj.demo.entity.DimCstTgCzTestEntity;
import com.zckj.demo.service.DimCstTgCzTestService;


@Service("dimCstTgCzTestService")
public class DimCstTgCzTestServiceImpl extends ServiceImpl<DimCstTgCzTestDao, DimCstTgCzTestEntity> implements DimCstTgCzTestService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DimCstTgCzTestEntity> page = this.page(
                new Query<DimCstTgCzTestEntity>().getPage(params),
                new QueryWrapper<DimCstTgCzTestEntity>()
        );

        return new PageUtils(page);
    }

}