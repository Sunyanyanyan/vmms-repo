package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.generator.dao.WorkerDao;
import io.renren.modules.generator.entity.WorkerEntity;
import io.renren.modules.generator.service.WorkerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("workerService")
public class WorkerServiceImpl extends ServiceImpl<WorkerDao, WorkerEntity> implements WorkerService {

    @Autowired
    private WorkerDao workerDao;


    @Override
    public boolean updatePassword(String workerId, String password, String newPassword) {
        WorkerEntity workerEntity = new WorkerEntity();
        workerEntity.setPwd(newPassword);
        return this.update(workerEntity,
                new QueryWrapper<WorkerEntity>().eq("WORKERID", workerId).eq("PWD",password));
    }

    @Override
    public List<String> queryAllMenuId(String workerId) {
        return baseMapper.queryAllMenuId(workerId);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //多条件组合查询.
        //动态sql
        QueryWrapper<WorkerEntity> queryWrapper = new QueryWrapper<>();
        String key = (String) params.get("key");
        //判断是否为空，如果不为空拼接条件
        //字段名字
        if (!StringUtils.isEmpty(key)) {
            //构建条件，模糊查询
            queryWrapper.like("WORKERNAME", key)
                    .or().like("ORGNO",key)
                    .or().like("WORKERID",key)
                    .or().like("WGNO",key)
                    .or().like("CODE",key);
        }

        IPage<WorkerEntity> page = this.page(
                new Query<WorkerEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public boolean saveWorker(WorkerEntity worker) {
        boolean insert = false;
        try {
            worker.setWorkerid(workerDao.maxWorkerid());

            insert = workerDao.insertWorker(worker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insert;
    }

    @Override
    public boolean updateWorker(WorkerEntity worker) {
        return workerDao.updateWorker(worker);
    }

    @Override
    public WorkerEntity getByWorkerId(String workerId) {
        return workerDao.getByWorkerId(workerId);
    }

    @Override
    public WorkerEntity queryByUserName(String code) {
        return baseMapper.queryByUserName(code);
    }


}