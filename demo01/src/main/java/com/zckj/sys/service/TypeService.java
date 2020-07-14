package com.zckj.sys.service;

import com.zckj.sys.entity.Type;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
public interface TypeService extends IService<Type> {

    /**
     * 取数据type表中的单位等级
     *
     * @param grade
     * @return Type
     */
    List<Type> getTypeByGrade(String grade);

    List<Type> getType(String orgno, String name);
}
