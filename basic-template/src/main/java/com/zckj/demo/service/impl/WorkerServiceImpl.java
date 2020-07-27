package com.zckj.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.common.utils.PageUtils;
import com.zckj.common.utils.Query;

import com.zckj.demo.dao.WorkerDao;
import com.zckj.demo.entity.WorkerEntity;
import com.zckj.demo.service.WorkerService;


@Service("workerService")
public class WorkerServiceImpl extends ServiceImpl<WorkerDao, WorkerEntity> implements WorkerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WorkerEntity> page = this.page(
                new Query<WorkerEntity>().getPage(params),
                new QueryWrapper<WorkerEntity>()
        );

        return new PageUtils(page);
    }

}