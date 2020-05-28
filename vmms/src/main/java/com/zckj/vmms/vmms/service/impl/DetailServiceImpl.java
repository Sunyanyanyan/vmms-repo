package com.zckj.vmms.vmms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.Query;

import com.zckj.vmms.vmms.dao.DetailDao;
import com.zckj.vmms.vmms.entity.DetailEntity;
import com.zckj.vmms.vmms.service.DetailService;


@Service("detailService")
public class DetailServiceImpl extends ServiceImpl<DetailDao, DetailEntity> implements DetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DetailEntity> page = this.page(
                new Query<DetailEntity>().getPage(params),
                new QueryWrapper<DetailEntity>()
        );

        return new PageUtils(page);
    }

}