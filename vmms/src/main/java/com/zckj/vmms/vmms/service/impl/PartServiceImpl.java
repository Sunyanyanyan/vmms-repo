package com.zckj.vmms.vmms.service.impl;

import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zckj.vmms.vmms.dao.PartDao;
import com.zckj.vmms.vmms.entity.PartEntity;
import com.zckj.vmms.vmms.service.PartService;


@Service("partService")
public class PartServiceImpl extends ServiceImpl<PartDao, PartEntity> implements PartService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PartEntity> page = this.page(
                new Query<PartEntity>().getPage(params),
                new QueryWrapper<PartEntity>()
        );

        return new PageUtils(page);
    }

}