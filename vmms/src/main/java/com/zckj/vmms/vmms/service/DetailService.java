package com.zckj.vmms.vmms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.vmms.entity.DetailEntity;

import java.util.Map;

/**
 * 维修清单详情
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
public interface DetailService extends IService<DetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

