package com.zckj.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.common.utils.PageUtils;
import com.zckj.common.utils.Query;

import com.zckj.demo.dao.OrgDao;
import com.zckj.demo.entity.OrgEntity;
import com.zckj.demo.service.OrgService;


@Service("orgService")
public class OrgServiceImpl extends ServiceImpl<OrgDao, OrgEntity> implements OrgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrgEntity> page = this.page(
                new Query<OrgEntity>().getPage(params),
                new QueryWrapper<OrgEntity>()
        );

        return new PageUtils(page);
    }

}