package com.zckj.sys.service.impl;

import com.zckj.sys.entity.Type;
import com.zckj.sys.mapper.TypeMapper;
import com.zckj.sys.service.TypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

    @Autowired
    private  TypeMapper typeMapper;
    @Override
    public List<Type> getTypeByGrade(String grade) {
        List<Type> type = typeMapper.getTypeByGrade(grade);
        return type;
    }

    @Override
    public List<Type> getType(String orgno, String name) {
        if(orgno.length()>7)
        {
            orgno = orgno.substring(0, 7);
        }
        List<Type> type = typeMapper.getType(orgno,name);
        return type;
    }
}
