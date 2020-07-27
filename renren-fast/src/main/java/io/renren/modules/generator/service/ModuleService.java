package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ModuleEntity;
import org.apache.commons.lang.StringUtils;


import java.util.List;
import java.util.Map;

/**
 * 模块
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
public interface ModuleService extends IService<ModuleEntity> {
    /**
     * 根据父菜单，查询子菜单
     * @param parent 父菜单
     * @param moduleIdList  用户菜单ID
     */
    List<ModuleEntity> queryListParent(String parent, List<String> moduleIdList);

    /**
     * 根据父菜单，查询子菜单
     * @param parent 父菜单
     */
    List<ModuleEntity> queryListParent(String parent);

    /**
     * 获取不包含按钮的菜单列表
     */
    List<ModuleEntity> queryNotButtonList();

    /**
     * 获取用户菜单列表
     */
    List<ModuleEntity> getWorkerMenuList(String workerId);

    /**
     * 删除
     */
    void delete(String  moduleId);




    void insertModule(ModuleEntity module);
}

