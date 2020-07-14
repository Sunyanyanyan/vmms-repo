package com.zckj.sys.service;

import com.zckj.sys.entity.Worker;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zckj.sys.utils.PageUtils;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
public interface WorkerService extends IService<Worker> {

    /**
     * 用户登录验证
     *
     * @param username
     *            password
     * @return
     */
    public Worker getWorker(String username, String password);

    PageUtils queryPage(Map<String, Object> params);

    boolean saveWorker(Worker worker);

    boolean updateWorker(Worker worker);

    Worker getByWorkerId(String workerid);

    // 登录
    String login(Worker worker);
}
