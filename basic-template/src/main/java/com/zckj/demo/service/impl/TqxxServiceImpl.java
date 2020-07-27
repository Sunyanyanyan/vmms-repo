package com.zckj.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.common.utils.PageUtils;
import com.zckj.common.utils.Query;

import com.zckj.demo.dao.TqxxDao;
import com.zckj.demo.entity.TqxxEntity;
import com.zckj.demo.service.TqxxService;


@Service("tqxxService")
public class TqxxServiceImpl extends ServiceImpl<TqxxDao, TqxxEntity> implements TqxxService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TqxxEntity> page = this.page(
                new Query<TqxxEntity>().getPage(params),
                new QueryWrapper<TqxxEntity>()
        );

        return new PageUtils(page);
    }

}