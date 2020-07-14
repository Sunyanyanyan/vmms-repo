package com.zckj.sys.service;

import com.zckj.sys.entity.Org;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zckj.sys.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
public interface OrgService extends IService<Org> {
    PageUtils queryPage(Map<String, Object> params);


    List<Org> listWithTree();

    void removeMenuByIds(List<String> asList);

    void saveOrg(Org org);

    /**
     * 返回用户供电单位范围
     *
     * @param orgno 用户单位编号
     * @return
     */
    Org getOrg(String orgno);
    /**
     * 查询操作员年在及下属单位列表
     *
     * @param orgno
     *            用户所在单位编号
     * @return List<Org>
     */
    List<Org> selectOrg(String orgno);
}
