package com.zckj.vmms.vmms.dao;

import com.zckj.vmms.vmms.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

/**
 * 维修工单
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {

//     OrderEntity query(OrderEntity order);//查询，会将List<Adress>也一起查出来

//     @Results(id="stuMap",value = {
//             @Result(property="orderId", column="order_id"),
//             @Result(property="shopId", column="shop_id"),
//             @Result(property="carId", column="car_id"),
//             @Result(property="regionNumber", column="region_number"),
//                     @Result(property="applicationTime", column="application_time"),
//                     @Result(property="name", column="name"),
//                     @Result(property="applicantNumber", column="applicant_number"),
//                     @Result(property="status", column="status"),
//                     @Result(property="attribute" ,column="attribute"),
//                     @Result(property="beforeImgUrl", column="before_img_url"),
//                     @Result(property="afterImgUrl", column="after_img_url"),
//                     @Result(property="damageImgUrl", column="damage_img_url"),
//                     @Result(property="description", column="description"),
//                     @Result(property="startTime", column="start_time"),
//                     @Result(property="endTime", column="end_time"),
//                     @Result(property="exportStatus", column="export_status"),
//                     @Result(property="longitude", column="longitude"),
//                     @Result(property="latitude", column="latitude"),
//             @Result(property = "studentClass",column = "ClassID",one = @One(select = "com.lyb.springmybatisdemo.mapper.StudentClassMapper.selectById"))
//     })
//     @Select("SELECT * FROM STUDENT WHERE ID=#{id}")
//     OrderEntity findOrderById(int id);


     /**
      * 查询订单表最后一条记录的主键值
      * @return
      */
     String queryMaxOrderId();

}
