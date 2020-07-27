package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.WorkerEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作员
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
@Mapper
public interface WorkerDao extends BaseMapper<WorkerEntity> {


    /**
     * 查询用户的所有菜单ID
     */
    List<String> queryAllMenuId(String workerId);

    String maxWorkerid();

    boolean insertWorker(WorkerEntity worker);

    boolean updateWorker(WorkerEntity worker);

    WorkerEntity getByWorkerId(String workerid);

    WorkerEntity queryByUserName(String code);
}
