package com.zckj.vmms.vmms.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.vmms.entity.BillEntity;

import java.util.Map;

/**
 * 报账费用
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-22 16:42:59
 */
public interface BillService extends IService<BillEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

