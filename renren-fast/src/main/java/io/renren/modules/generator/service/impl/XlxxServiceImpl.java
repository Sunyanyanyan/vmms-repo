package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.XlxxDao;
import io.renren.modules.generator.entity.XlxxEntity;
import io.renren.modules.generator.service.XlxxService;


@Service("xlxxService")
public class XlxxServiceImpl extends ServiceImpl<XlxxDao, XlxxEntity> implements XlxxService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<XlxxEntity> page = this.page(
                new Query<XlxxEntity>().getPage(params),
                new QueryWrapper<XlxxEntity>()
        );

        return new PageUtils(page);
    }

}