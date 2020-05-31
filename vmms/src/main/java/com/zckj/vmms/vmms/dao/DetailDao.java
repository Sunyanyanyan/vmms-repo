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

//    int insert();

//    @Results(id = "detailMap", value = {
//            @Result(property = "detailId", column = "detail_id"),
//            @Result(property = "item", column = "item"),
//            @Result(property = "itemBill", column = "item_bill"),
//            @Result(property = "orderId", column = "order_id", one = @One(select = "com.zckj.vmms.vmms.dao.OrderDao.selectById"))
//    })
//    @Select("SELECT * FROM t_detail WHERE detail_id=#{detail_id}")
//    DetailEntity findStudentById(int id);
//
//    @Select("select * from t_detail where 1=1 and " + "${ew.sqlSegment}")
//    @ResultMap(value = "detailMap")
//    List<DetailEntity> selectDetail(@Param("ew") QueryWrapper<DetailEntity> wrapper);

    /**
     * 查询维修清单最后一条记录的主键值
     * @return
     */
    String queryMaxDetailId();


}
