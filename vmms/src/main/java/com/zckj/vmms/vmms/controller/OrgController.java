package com.zckj.vmms.vmms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zckj.vmms.utils.R;
import com.zckj.vmms.vmms.entity.OrgEntity;
import com.zckj.vmms.vmms.service.OrgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-02 15:47:24
 */
@Api(tags = "申请人信息接口")
@RestController
@RequestMapping("vmms/org")
public class OrgController {
    @Autowired
    private OrgService orgService;

    @ApiOperation("根据openId查询申请人信息")
    @GetMapping(value = "/findByOpenId", produces = {"application/json;charset=UTF-8"})
    @ApiImplicitParam(name = "openId", value = "用户唯一标识", required = true)
    public R findByOpenId(OrgEntity orgEntity) {
        QueryWrapper<OrgEntity> queryWrapper = new QueryWrapper<>();

        String openId = orgEntity.getOpenId();
        //构建条件
        queryWrapper.eq("open_id", openId);

        List<OrgEntity> list = orgService.list(queryWrapper);
        if (list.size() > 0) {

            return R.ok().put("list", list);
        }
        return R.error("查询信息不存在");
    }


//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{applicantNumber}")
//    public R info(@PathVariable("applicantNumber") String applicantNumber){
//		OrgEntity org = orgService.getById(applicantNumber);
//
//        return R.ok().put("org", org);
//    }
//

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(OrgEntity org) {
        orgService.save(org);

        return R.ok();
    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    public R update(@RequestBody OrgEntity org){
//		orgService.updateById(org);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody String[] applicantNumbers){
//		orgService.removeByIds(Arrays.asList(applicantNumbers));
//
//        return R.ok();
//    }

}
