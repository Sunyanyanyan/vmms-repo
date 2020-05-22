package com.zckj.vmms.vmms.service.impl;

import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zckj.vmms.vmms.dao.ApplyDao;
import com.zckj.vmms.vmms.entity.ApplyEntity;
import com.zckj.vmms.vmms.service.ApplyService;


@Service("applyService")
public class ApplyServiceImpl extends ServiceImpl<ApplyDao, ApplyEntity> implements ApplyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ApplyEntity> page = this.page(
                new Query<ApplyEntity>().getPage(params),
                new QueryWrapper<ApplyEntity>()
        );

        return new PageUtils(page);
    }

}