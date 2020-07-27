package com.zckj.vmms.vmms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.Query;

import com.zckj.vmms.vmms.dao.OrgDao;
import com.zckj.vmms.vmms.entity.OrgEntity;
import com.zckj.vmms.vmms.service.OrgService;


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