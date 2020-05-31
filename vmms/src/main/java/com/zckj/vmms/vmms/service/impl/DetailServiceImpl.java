package com.zckj.vmms.vmms.service.impl;

import com.zckj.vmms.utils.IdUtil;
import com.zckj.vmms.utils.R;
import com.zckj.vmms.vmms.dao.OrderDao;
import com.zckj.vmms.vmms.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.Query;

import com.zckj.vmms.vmms.dao.DetailDao;
import com.zckj.vmms.vmms.entity.DetailEntity;
import com.zckj.vmms.vmms.service.DetailService;

import javax.annotation.PostConstruct;


@Service("detailService")
public class DetailServiceImpl extends ServiceImpl<DetailDao, DetailEntity> implements DetailService {

    @Autowired
    private DetailDao detailDao;


//    public void testByWrapper() {
//        QueryWrapper<DetailEntity> queryWrapper = new QueryWrapper<DetailEntity>();
//        queryWrapper.lambda().eq(DetailEntity::getItem, "轮胎")
//                .eq(DetailEntity::getOrderId, 202000005);
//
//        List<DetailEntity> detail = detailDao.selectDetail(queryWrapper);
//    }

    @Override
    public int saveDetail(DetailEntity detail) {
        String lastIdStr = detailDao.queryMaxDetailId();

        if (lastIdStr != null) {
            int lastId = Integer.parseInt(lastIdStr);
            Integer detailId = IdUtil.getDetailId(lastId);
            detail.setDetailId(detailId);
        }

        OrderEntity orderEntity = new OrderEntity();
        Integer orderId = orderEntity.getOrderId();
        detail.setOrderId(orderId);

        return detailDao.insert(detail);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DetailEntity> page = this.page(
                new Query<DetailEntity>().getPage(params),
                new QueryWrapper<DetailEntity>()
        );

        return new PageUtils(page);
    }
}