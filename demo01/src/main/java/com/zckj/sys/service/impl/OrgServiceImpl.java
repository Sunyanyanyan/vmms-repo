package com.zckj.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zckj.sys.entity.Org;
import com.zckj.sys.mapper.OrgMapper;
import com.zckj.sys.service.OrgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.sys.utils.PageUtils;
import com.zckj.sys.utils.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements OrgService {


    @Autowired
    private OrgMapper orgMapper;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Org> page = this.page(
                new Query<Org>().getPage(params),
                new QueryWrapper<Org>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Org> listWithTree() {
        //1、查出所有分类
        List<Org> entities = baseMapper.selectList(null);

        //2、组装成父子的树形结构

        //2.1、找到所有的一级分类
        List<Org> level1Menus = entities.stream().filter(Org ->
                Org.getParentno().equals("434")
        ).map((menu)->{
            menu.setChildren(getChildrens(menu,entities));
            return menu;
        }).collect(Collectors.toList());

        for (Org level1Menu : level1Menus) {
            log.info(String.valueOf(level1Menu));
        }
        return level1Menus;
    }

    @Override
    public void removeMenuByIds(List<String> asList) {
        // TODO 检查当前删除的菜单，是否被别的地方引用
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public void saveOrg(Org org) {

        String orgno = org.getParentno() + orgMapper.maxOrgNo(org);
        log.info("getParentno:"+org.getParentno());
        log.info("maxOrgNo:"+ orgMapper.maxOrgNo(org));
        org.setOrgno(orgno);

        log.info("orgno:"+orgno);
        orgMapper.insertOrg(org);
    }


    /**
     * 递归查找所有菜单的子菜单
     * @param root  当前菜单
     * @param all   子菜单
     * @return
     */
    private List<Org> getChildrens(Org root,List<Org> all){

        List<Org> children = all.stream().filter(Org -> {
            return Org.getParentno().equals(root.getOrgno());
        }).map(Org -> {
            // 找到子菜单
            Org.setChildren(getChildrens(Org,all));
            log.info("Org-----" + Org);
            return Org;
        }).collect(Collectors.toList());

        return children;
    }

    public Org getOrg(String orgno) {
        Org org = orgMapper.getOrg(orgno);
        return org;
    }

    public List<Org> selectOrg(String orgno) {
        List<Org> org = orgMapper.selectOrg(orgno);
        return org;
    }
}
