package com.zckj.vmms.vmms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.Query;

import com.zckj.vmms.vmms.dao.RepairShopDao;
import com.zckj.vmms.vmms.entity.RepairShopEntity;
import com.zckj.vmms.vmms.service.RepairShopService;


@Service("repairShopService")
public class RepairShopServiceImpl extends ServiceImpl<RepairShopDao, RepairShopEntity> implements RepairShopService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RepairShopEntity> page = this.page(
                new Query<RepairShopEntity>().getPage(params),
                new QueryWrapper<RepairShopEntity>()
        );

        return new PageUtils(page);
    }

}