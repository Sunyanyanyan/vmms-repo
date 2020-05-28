package com.zckj.vmms.vmms.service.impl;

import com.zckj.vmms.utils.R;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.Query;

import com.zckj.vmms.vmms.dao.OrderDao;
import com.zckj.vmms.vmms.entity.OrderEntity;
import com.zckj.vmms.vmms.service.OrderService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                new QueryWrapper<OrderEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R saveApply(String attribute, String description) {
        return null;
    }

}