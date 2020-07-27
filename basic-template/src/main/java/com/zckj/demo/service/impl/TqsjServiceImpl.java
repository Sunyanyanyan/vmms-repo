package com.zckj.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.common.utils.PageUtils;
import com.zckj.common.utils.Query;

import com.zckj.demo.dao.TqsjDao;
import com.zckj.demo.entity.TqsjEntity;
import com.zckj.demo.service.TqsjService;


@Service("tqsjService")
public class TqsjServiceImpl extends ServiceImpl<TqsjDao, TqsjEntity> implements TqsjService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TqsjEntity> page = this.page(
                new Query<TqsjEntity>().getPage(params),
                new QueryWrapper<TqsjEntity>()
        );

        return new PageUtils(page);
    }

}