package com.zckj.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zckj.sys.common.exception.MyException;
import com.zckj.sys.entity.Worker;
import com.zckj.sys.mapper.WorkerMapper;
import com.zckj.sys.service.WorkerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.sys.utils.JwtUtils;
import com.zckj.sys.utils.MD5Util;
import com.zckj.sys.utils.PageUtils;
import com.zckj.sys.utils.Query;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
@Service
@Slf4j
public class WorkerServiceImpl extends ServiceImpl<WorkerMapper, Worker> implements WorkerService {
    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public Worker getWorker(String username, String password) {
        Worker worker = workerMapper.getWorker(username,password);
        return worker;
    }


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //多条件组合查询.
        //动态sql
        QueryWrapper<Worker> queryWrapper = new QueryWrapper<>();
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

        IPage<Worker> page = this.page(
                new Query<Worker>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public boolean saveWorker(Worker worker) {
        boolean insert = false;
        try {
            worker.setWorkerid(workerMapper.maxWorkerid());

            insert = workerMapper.insertWorker(worker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insert;
    }

    @Override
    public boolean updateWorker(Worker worker) {
        return workerMapper.updateWorker(worker);
    }

    @Override
    public Worker getByWorkerId(String workerId) {
        return workerMapper.getByWorkerId(workerId);
    }

    /**
     * 登录
     * @param worker
     * @return
     */
    @Override
    public String login(@RequestBody Worker worker) {
        // 获取登录用户名和密码
        String username = worker.getCode();
        String password = worker.getPwd();

        // 用户名和密码非空判断
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new MyException("登录失败", 20001);
        }
        // 判断用户名是否正确
        QueryWrapper<Worker> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", username);
        Worker queryWorker = baseMapper.selectOne(queryWrapper);

        // 判断查询对象是否为空
        if (queryWorker == null) {
            throw new MyException("登录失败", 20001);
        }
        // 判断密码
        // 把输入的密码进行加密，再和数据库的密码进行比较
        // 加密方式 MD5
        if (!MD5Util.encrypt_string(password,"utf-8").equals(queryWorker.getPwd())) {
            throw new MyException("登录失败", 20001);
        }

        // 判断用户状态是否正常
        if (!"正常".equals(queryWorker.getState())) {
            throw new MyException("登录失败", 20001);
        }

        // 登录成功
        // 生成token字符串，使用jwt工具类
        String jwtToken = JwtUtils.geneJsonWebToken(queryWorker);
        return jwtToken;
    }
}
