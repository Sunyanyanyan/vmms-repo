package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.TqxxEntity;

import java.util.Map;

/**
 * 台区信息
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
public interface TqxxService extends IService<TqxxEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

