package com.zckj.vmms.vmms.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.vmms.utils.IdUtil;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.Query;
import com.zckj.vmms.vmms.dao.DetailDao;
import com.zckj.vmms.vmms.dao.OrderDao;
import com.zckj.vmms.vmms.entity.DetailEntity;
import com.zckj.vmms.vmms.entity.OrderEntity;
import com.zckj.vmms.vmms.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("orderService")
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private DetailDao detailDao;

    /**
     * 添加维修申请
     */
    @Override
    public int saveOrder(OrderEntity orderEntity) {
        DetailEntity detailEntity = new DetailEntity();
        String lastIdStr = orderDao.queryMaxOrderId();

        if (lastIdStr != null) {
            int lastId = Integer.parseInt(lastIdStr);
            Integer orderId = IdUtil.getOrderId(lastId);

            orderEntity.setOrderId(orderId);
        }

        String now = DateUtil.now();
        orderEntity.setApplicationTime(now);
        int insert = orderDao.insert(orderEntity);
        //往清单表插入所属工单编号
        Integer orderId = orderEntity.getOrderId();
        detailEntity.setOrderId(orderId);
        detailDao.insert(detailEntity);

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