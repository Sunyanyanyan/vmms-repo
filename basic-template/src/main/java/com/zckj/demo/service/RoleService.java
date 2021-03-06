package com.zckj.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zckj.common.utils.PageUtils;
import com.zckj.demo.entity.RoleEntity;

import java.util.Map;

/**
 * ${comments}
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-10 20:14:07
 */
public interface RoleService extends IService<RoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

