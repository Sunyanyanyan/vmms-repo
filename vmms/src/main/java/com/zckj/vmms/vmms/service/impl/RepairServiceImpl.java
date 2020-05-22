package com.zckj.vmms.vmms.service.impl;

import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zckj.vmms.vmms.dao.RepairDao;
import com.zckj.vmms.vmms.entity.RepairEntity;
import com.zckj.vmms.vmms.service.RepairService;


@Service("repairService")
public class RepairServiceImpl extends ServiceImpl<RepairDao, RepairEntity> implements RepairService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RepairEntity> page = this.page(
                new Query<RepairEntity>().getPage(params),
                new QueryWrapper<RepairEntity>()
        );

        return new PageUtils(page);
    }

}