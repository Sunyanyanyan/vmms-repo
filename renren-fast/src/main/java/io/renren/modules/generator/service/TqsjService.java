package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.TqsjEntity;

import java.util.Map;

/**
 * 台区数据
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
public interface TqsjService extends IService<TqsjEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

