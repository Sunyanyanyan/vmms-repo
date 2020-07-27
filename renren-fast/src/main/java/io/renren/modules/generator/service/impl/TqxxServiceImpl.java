package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.TqxxDao;
import io.renren.modules.generator.entity.TqxxEntity;
import io.renren.modules.generator.service.TqxxService;


@Service("tqxxService")
public class TqxxServiceImpl extends ServiceImpl<TqxxDao, TqxxEntity> implements TqxxService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TqxxEntity> page = this.page(
                new Query<TqxxEntity>().getPage(params),
                new QueryWrapper<TqxxEntity>()
        );

        return new PageUtils(page);
    }

}