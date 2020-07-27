package com.zckj.vmms.vmms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zckj.vmms.vmms.entity.DetailEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 维修清单详情
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
@Mapper
public interface DetailDao extends BaseMapper<DetailEntity> {

    /**
     * 查询维修清单最后一条记录的主键值
     */
    String queryMaxDetailId();

}
