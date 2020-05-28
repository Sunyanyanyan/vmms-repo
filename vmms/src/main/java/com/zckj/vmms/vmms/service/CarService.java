package com.zckj.vmms.vmms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.vmms.entity.CarEntity;

import java.util.Map;

/**
 * 车牌号表
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
public interface CarService extends IService<CarEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

