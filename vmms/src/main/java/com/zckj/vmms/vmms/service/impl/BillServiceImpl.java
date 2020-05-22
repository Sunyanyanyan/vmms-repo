package com.zckj.vmms.vmms.service.impl;

import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zckj.vmms.vmms.dao.BillDao;
import com.zckj.vmms.vmms.entity.BillEntity;
import com.zckj.vmms.vmms.service.BillService;


@Service("billService")
public class BillServiceImpl extends ServiceImpl<BillDao, BillEntity> implements BillService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BillEntity> page = this.page(
                new Query<BillEntity>().getPage(params),
                new QueryWrapper<BillEntity>()
        );

        return new PageUtils(page);
    }

}