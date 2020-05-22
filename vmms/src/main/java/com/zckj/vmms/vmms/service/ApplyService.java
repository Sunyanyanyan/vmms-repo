package com.zckj.vmms.vmms.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.vmms.entity.ApplyEntity;

import java.util.Map;

/**
 * 车辆维修申请
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-22 16:42:59
 */
public interface ApplyService extends IService<ApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

