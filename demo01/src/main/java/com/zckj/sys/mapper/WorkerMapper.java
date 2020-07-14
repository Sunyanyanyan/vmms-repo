package com.zckj.sys.mapper;

import com.zckj.sys.entity.Worker;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
@Mapper
public interface WorkerMapper extends BaseMapper<Worker> {

    /**
     * 用户登录验证
     * @param username
     * @param password
     * @return
     */
    Worker getWorker(@Param("username")String username, @Param("password")String password);

    String maxWorkerid();

    boolean insertWorker(Worker worker);

    boolean updateWorker(Worker worker);

    Worker getByWorkerId(String workerid);
}
