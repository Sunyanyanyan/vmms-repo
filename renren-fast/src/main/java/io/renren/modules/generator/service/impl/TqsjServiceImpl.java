package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.TqsjDao;
import io.renren.modules.generator.entity.TqsjEntity;
import io.renren.modules.generator.service.TqsjService;


@Service("tqsjService")
public class TqsjServiceImpl extends ServiceImpl<TqsjDao, TqsjEntity> implements TqsjService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TqsjEntity> page = this.page(
                new Query<TqsjEntity>().getPage(params),
                new QueryWrapper<TqsjEntity>()
        );

        return new PageUtils(page);
    }

}