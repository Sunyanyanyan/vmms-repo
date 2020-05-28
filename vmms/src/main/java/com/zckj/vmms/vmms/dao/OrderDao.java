package com.zckj.vmms.vmms.dao;

import com.zckj.vmms.vmms.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 维修工单
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
