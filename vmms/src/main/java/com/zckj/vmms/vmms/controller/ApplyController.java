package com.zckj.vmms.vmms.controller;

import java.util.Arrays;
import java.util.Map;

import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.R;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zckj.vmms.vmms.entity.ApplyEntity;
import com.zckj.vmms.vmms.service.ApplyService;


/**
 * 车辆维修申请
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-22 16:42:59
 */
@RestController
@RequestMapping("/vmms/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    /**
     * 列表
     */
/*
    @GetMapping(value = "/list",produces = {"application/json;charset=UTF-8"})
    @ApiOperation("查询所有维修申请信息")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = applyService.queryPage(params);

        return R.ok().put("page", page);
    }
*/


    /**
     * 信息
     */
/*    @GetMapping(value = "/info/{applyId}",produces = {"application/json;charset=UTF-8"})
    @ApiOperation("根据id查询维修申请信息")
    public R info(@PathVariable("applyId") String applyId){
		ApplyEntity apply = applyService.getById(applyId);

        return R.ok().put("apply", apply);
    }*/

    /**
     * 保存
     */
    @PostMapping(value = "/save", produces = {"application/json;charset=UTF-8"})
    @ApiModelProperty(value = "添加维修申请", notes = "以实体类为参数")
    public R save(@RequestBody ApplyEntity apply){
		applyService.save(apply);

        return R.ok();
    }

    /**
     * 修改
     */
/*    @PutMapping("/update")
    public R update(@RequestBody ApplyEntity apply){
		applyService.updateById(apply);

        return R.ok();
    }

    *//**
     * 删除
     *//*
    @DeleteMapping("/delete")
    public R delete(@RequestBody String[] applyIds){
		applyService.removeByIds(Arrays.asList(applyIds));

        return R.ok();
    }*/

}
