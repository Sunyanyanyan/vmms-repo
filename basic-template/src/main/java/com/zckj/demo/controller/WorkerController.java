package com.zckj.demo.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zckj.demo.entity.WorkerEntity;
import com.zckj.demo.service.WorkerService;
import com.zckj.common.utils.PageUtils;
import com.zckj.common.utils.R;



/**
 * ${comments}
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-10 20:14:07
 */
@RestController
@RequestMapping("demo/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = workerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orgno}")
    public R info(@PathVariable("orgno") String orgno){
		WorkerEntity worker = workerService.getById(orgno);

        return R.ok().put("worker", worker);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WorkerEntity worker){
		workerService.save(worker);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WorkerEntity worker){
		workerService.updateById(worker);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] orgnos){
		workerService.removeByIds(Arrays.asList(orgnos));

        return R.ok();
    }

}
