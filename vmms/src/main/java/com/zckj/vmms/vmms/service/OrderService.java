package com.zckj.vmms.vmms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.R;
import com.zckj.vmms.vmms.entity.OrderEntity;

import java.util.Map;

/**
 * 维修工单
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int addApply(String attribute, String description);
}

