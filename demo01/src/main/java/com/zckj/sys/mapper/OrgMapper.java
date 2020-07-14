package com.zckj.sys.mapper;

import com.zckj.sys.entity.Org;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
@Mapper
public interface OrgMapper extends BaseMapper<Org> {
    /**
     * 机构维护-插入记录
     *
     * @param org
     * @return 返回
     *
     */
    void insertOrg(Org org);

    /**
     * 机构维护-查询指定级别的最大单位编号+1
     *
     * @param org
     * @return 返回最大orgno+1
     *
     */
    String maxOrgNo(Org org);
    /**
     * 返回用户供电单位范围
     * @param orgno 用户单位编号
     * @return
     */
    Org getOrg(String orgno);
    /**
     * 查询操作员年在及下属单位列表
     * @param orgno 用户所在单位编号
     * @return List<Org>
     */
    public List<Org> selectOrg(String orgno);
}
