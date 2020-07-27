package io.renren.modules.generator.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.OrgDao;
import io.renren.modules.generator.entity.OrgEntity;
import io.renren.modules.generator.service.OrgService;


@Service("orgService")
@Slf4j
public class OrgServiceImpl extends ServiceImpl<OrgDao, OrgEntity> implements OrgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrgEntity> page = this.page(
                new Query<OrgEntity>().getPage(params),
                new QueryWrapper<OrgEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<OrgEntity> listWithTree() {
        //1、查出所有分类
        List<OrgEntity> entities = baseMapper.selectList(null);

        //2、组装成父子的树形结构

        //2.1）、找到所有的一级分类
        List<OrgEntity> level1Menus = entities.stream().filter(orgEntity ->
                orgEntity.getParentno().equals("434")
        ).map((menu)->{
            menu.setChildren(getChildrens(menu,entities));
            return menu;
        }).collect(Collectors.toList());

        for (OrgEntity level1Menu : level1Menus) {
            log.info(String.valueOf(level1Menu));
        }
        return level1Menus;
    }

    @Override
    public void removeMenuByIds(List<String> asList) {
        // TODO 检查当前删除的菜单，是否被别的地方引用
        baseMapper.deleteBatchIds(asList);
    }


    /**
     * 递归查找所有菜单的子菜单
     * @param root  当前菜单
     * @param all   子菜单
     * @return
     */
    private List<OrgEntity> getChildrens(OrgEntity root,List<OrgEntity> all){

        List<OrgEntity> children = all.stream().filter(orgEntity -> {
            return orgEntity.getParentno().equals(root.getOrgno());
        }).map(orgEntity -> {
            // 找到子菜单
            orgEntity.setChildren(getChildrens(orgEntity,all));
            log.info("orgEntity-----" + orgEntity);
            return orgEntity;
        }).collect(Collectors.toList());

        return children;
    }

}