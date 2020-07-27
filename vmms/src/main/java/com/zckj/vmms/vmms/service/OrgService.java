package com.zckj.vmms.vmms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.vmms.entity.OrgEntity;

import java.util.Map;

/**
 * 
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-02 15:47:24
 */
public interface OrgService extends IService<OrgEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

