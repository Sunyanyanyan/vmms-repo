package com.zckj.sys.mapper;

import com.zckj.sys.entity.Type;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
@Mapper
public interface TypeMapper extends BaseMapper<Type> {

    /**
     * 取数据type表中的单位等级
     *
     * @param grade
     * @return Type
     */
    List<Type> getTypeByGrade(String grade);

    List<Type> getType(@Param("orgno")String orgno, @Param("name")String name);
}
