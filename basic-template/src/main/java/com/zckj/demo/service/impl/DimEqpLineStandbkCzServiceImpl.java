package com.zckj.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.common.utils.PageUtils;
import com.zckj.common.utils.Query;

import com.zckj.demo.dao.DimEqpLineStandbkCzDao;
import com.zckj.demo.entity.DimEqpLineStandbkCzEntity;
import com.zckj.demo.service.DimEqpLineStandbkCzService;


@Service("dimEqpLineStandbkCzService")
public class DimEqpLineStandbkCzServiceImpl extends ServiceImpl<DimEqpLineStandbkCzDao, DimEqpLineStandbkCzEntity> implements DimEqpLineStandbkCzService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DimEqpLineStandbkCzEntity> page = this.page(
                new Query<DimEqpLineStandbkCzEntity>().getPage(params),
                new QueryWrapper<DimEqpLineStandbkCzEntity>()
        );

        return new PageUtils(page);
    }

}