package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.MapUtils;
import io.renren.modules.generator.dao.ModuleDao;
import io.renren.modules.generator.entity.ModuleEntity;
import io.renren.modules.generator.entity.RoleEntity;
import io.renren.modules.generator.service.ModuleService;
import io.renren.modules.generator.service.RoleService;
import io.renren.modules.generator.service.WorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("moduleService")
@Slf4j
public class ModuleServiceImpl extends ServiceImpl<ModuleDao, ModuleEntity> implements ModuleService {

    @Autowired
    private ModuleDao moduleDao;

    @Autowired
    private WorkerService workerService;

    @Autowired
    private RoleService roleService;


    @Override
    public List<ModuleEntity> queryListParent(String parent, List<String> moduleIdList) {
        List<ModuleEntity> moduleList = queryListParent(parent);

        if (moduleIdList == null) {
            return moduleList;
        }

        ArrayList<ModuleEntity> workerMenuList = new ArrayList<>();
        for (ModuleEntity moduleEntity : workerMenuList) {
            if (moduleIdList.contains(moduleEntity.getModuleid())) {
                workerMenuList.add(moduleEntity);
            }
        }
        return workerMenuList;
    }

    @Override
    public List<ModuleEntity> queryListParent(String parent) {
        QueryWrapper<ModuleEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("PARENT", parent);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<ModuleEntity> queryNotButtonList() {
        // TODO queryNotButtonList
        return baseMapper.queryNotButtonList();
    }

    @Override
    public List<ModuleEntity> getWorkerMenuList(String workerId) {
        //用户菜单列表
        List<String> moduleIdList = workerService.queryAllMenuId(workerId);
        return getAllMenuList(moduleIdList);
    }

    @Override
    public void delete(String moduleId) {
        //删除菜单
        this.removeById(moduleId);
        //删除菜单与角色关联
        workerService.removeByMap(new MapUtils().put("moduleid", moduleId));
    }


    /**
     * 获取所有菜单列表
     */
    private List<ModuleEntity> getAllMenuList(List<String> moduleIdList){
        //查询根菜单列表
        QueryWrapper<RoleEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("ROLEID");
        List<RoleEntity> list = roleService.list(queryWrapper);
        for (RoleEntity roleEntity : list) {
            log.info(roleEntity.getRoleid());
        }
        List<ModuleEntity> moduleList = queryListParent("系统管理", moduleIdList);
        //递归获取子菜单
        getMenuTreeList(moduleList, moduleIdList);

        return moduleList;
    }

    /**
     * 递归
     */
    private List<ModuleEntity> getMenuTreeList(List<ModuleEntity> moduleList, List<String> moduleIdList){
        List<ModuleEntity> subMenuList = new ArrayList<ModuleEntity>();

        for(ModuleEntity entity : moduleList){
            //目录
//            if(entity.getType() == Constant.MenuType.CATALOG.getValue()){
                entity.setList(getMenuTreeList(queryListParent(Integer.toString(entity.getModuleid()), moduleIdList), moduleIdList));
//            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }


    @Override
    public void insertModule(ModuleEntity module) {

        try {
            module.setModuleid(moduleDao.maxModuleID());
            moduleDao.insertModule(module);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}