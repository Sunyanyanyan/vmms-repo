package com.zckj.vmms.vmms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.vmms.entity.PartEntity;

import java.util.Map;

/**
 * 备件
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-22 16:42:59
 */
public interface PartService extends IService<PartEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

