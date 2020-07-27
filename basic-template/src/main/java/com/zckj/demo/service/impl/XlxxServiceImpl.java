package com.zckj.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.common.utils.PageUtils;
import com.zckj.common.utils.Query;

import com.zckj.demo.dao.XlxxDao;
import com.zckj.demo.entity.XlxxEntity;
import com.zckj.demo.service.XlxxService;


@Service("xlxxService")
public class XlxxServiceImpl extends ServiceImpl<XlxxDao, XlxxEntity> implements XlxxService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<XlxxEntity> page = this.page(
                new Query<XlxxEntity>().getPage(params),
                new QueryWrapper<XlxxEntity>()
        );

        return new PageUtils(page);
    }

}