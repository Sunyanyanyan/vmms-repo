package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.XlxxEntity;

import java.util.Map;

/**
 * 线路信息
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
public interface XlxxService extends IService<XlxxEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

