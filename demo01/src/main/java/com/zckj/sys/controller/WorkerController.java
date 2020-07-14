package com.zckj.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zckj.sys.common.R;
import com.zckj.sys.entity.Worker;
import com.zckj.sys.service.WorkerService;
import com.zckj.sys.utils.MD5Util;
import com.zckj.sys.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
@RestController
@RequestMapping("/sys/worker")
@Slf4j
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    /**
     * 列表
     *         params: {
     *           page: this.pageIndex,
     *           limit: this.pageSize,
     *           key: this.dataForm.key
     *         }
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = workerService.queryPage(params);
        log.info("/sys/worker/list--------getTotalCount"+page.getTotalCount());

        return R.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{workerid}")
    public R info(@PathVariable("workerid") String workerId) {

        log.info("workerid-------------------" + workerId);
        Worker worker = workerService.getByWorkerId(workerId);

        return R.ok().data("worker", worker);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R saveWorker(@RequestBody Worker worker) {
        // 密码加密
        String pwd = MD5Util.encrypt_string(worker.getPwd(),"utf-8");
        System.out.println("pwd===="+pwd);
        log.info("pwd===="+pwd);
        worker.setPwd(pwd);
        boolean b = workerService.saveWorker(worker);
        if (b) {
            return R.ok().data("workerid", worker.getWorkerid());
        }

        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R updateWorker(@RequestBody Worker worker) {
        boolean b = workerService.updateWorker(worker);
        if (b) {
            return R.ok();
        }

        return R.error();
    }


    /**
     * 删除/批量删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody String[] workerids) {
        // 构造删除条件
        QueryWrapper<Worker> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("WORKERID", workerids);
        workerService.remove(queryWrapper);

        return R.ok();
    }
}

