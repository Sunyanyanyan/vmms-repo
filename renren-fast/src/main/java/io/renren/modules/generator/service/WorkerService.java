package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.WorkerEntity;

import java.util.List;
import java.util.Map;

/**
 * 工作人员
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
public interface WorkerService extends IService<WorkerEntity> {

    /**
     * 修改密码
     * @param workerId       用户ID
     * @param password     原密码
     * @param newPassword  新密码
     */
    boolean updatePassword(String workerId, String password, String newPassword);



    /**
     * 查询用户的所有菜单ID
     */
    List<String> queryAllMenuId(String workerId);

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存操作员
     * @param worker
     * @return
     */
    boolean saveWorker(WorkerEntity worker);

    /**
     * 修改操作员
     * @param worker
     * @return
     */
    boolean updateWorker(WorkerEntity worker);

    WorkerEntity getByWorkerId(String workerid);

    WorkerEntity queryByUserName(String code);
}

