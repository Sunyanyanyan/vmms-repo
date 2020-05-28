package com.zckj.vmms.vmms.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.Query;
import com.zckj.vmms.vmms.dao.OrderDao;
import com.zckj.vmms.vmms.entity.OrderEntity;
import com.zckj.vmms.vmms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Autowired
    private OrderDao orderDao;
    /**
     * 添加维修申请
     * @param attribute
     * @param description
     */
    @Override
    public int addApply(String attribute, String description) {
        OrderEntity orderEntity = new OrderEntity();
        String now = DateUtil.now();
        orderEntity.setApplicationTime(now);
        orderEntity.setAttribute(attribute);
        orderEntity.setDescription(description);
        int insert = orderDao.insert(orderEntity);
        return insert;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                new QueryWrapper<OrderEntity>()
        );

        return new PageUtils(page);
    }

}