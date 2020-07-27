package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.OrgEntity;

import java.util.List;
import java.util.Map;

/**
 * ORG
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
public interface OrgService extends IService<OrgEntity> {

    PageUtils queryPage(Map<String, Object> params);


    List<OrgEntity> listWithTree();

    void removeMenuByIds(List<String> asList);
}

