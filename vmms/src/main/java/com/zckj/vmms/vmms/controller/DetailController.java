package com.zckj.vmms.vmms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zckj.vmms.vmms.entity.DetailEntity;
import com.zckj.vmms.vmms.service.DetailService;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.R;



/**
 * 维修清单详情
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
@RestController
@RequestMapping("vmms/detail")
public class DetailController {
    @Autowired
    private DetailService detailService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = detailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{detailId}")
    public R info(@PathVariable("detailId") Integer detailId){
		DetailEntity detail = detailService.getById(detailId);

        return R.ok().put("detail", detail);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody DetailEntity detail){
		detailService.save(detail);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody DetailEntity detail){
		detailService.updateById(detail);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Integer[] detailIds){
		detailService.removeByIds(Arrays.asList(detailIds));

        return R.ok();
    }

}
