package io.renren.modules.generator.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.annotation.SysLog;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.modules.generator.entity.WorkerEntity;
import io.renren.modules.generator.service.WorkerService;
import io.renren.modules.sys.controller.AbstractController;
import io.renren.modules.sys.form.PasswordForm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 操作员
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
@RestController
@RequestMapping("/generator/worker")
@Slf4j
public class WorkerController extends AbstractController {
    @Autowired
    private WorkerService workerService;

    /**
     * 所有操作员列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        // TODO 只有超级管理员，才能查看所有管理员列表
        PageUtils page = workerService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 获取登录的用户信息
     */
    @GetMapping("/info")
    public R info(){
        return R.ok().put("worker", getWorker());
    }

    /**
     * 修改登录用户密码
     */
    @SysLog("修改密码")
    @PostMapping("/password")
    public R password(@RequestBody PasswordForm form){
        Assert.isBlank(form.getNewPassword(), "新密码不为能空");

        //sha256加密
        String password = new Sha256Hash(form.getPassword(), getWorker()).toHex();
        //sha256加密
        String newPassword = new Sha256Hash(form.getNewPassword(), getWorker()).toHex();

        //更新密码
        boolean flag = workerService.updatePassword(getWorkerId(), password, newPassword);
        if(!flag){
            return R.error("原密码不正确");
        }

        return R.ok();
    }

    /**
     * 操作员信息
     */
    @GetMapping("/info/{workerid}")
    public R info(@PathVariable("workerid") String workerId) {

        log.info("workerid-------------------" + workerId);
        WorkerEntity worker = workerService.getByWorkerId(workerId);

        return R.ok().put("worker", worker);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R saveWorker(@RequestBody WorkerEntity worker) {
        boolean b = workerService.saveWorker(worker);
        if (b) {
            return R.ok().put("workerid", worker.getWorkerid());
        }

        return R.error("保存失败");
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R updateWorker(@RequestBody WorkerEntity worker) {
        boolean b = workerService.updateWorker(worker);
        if (b) {
            return R.ok();
        }

        return R.error("修改失败");
    }


    /**
     * 删除/批量删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody String[] workerids) {
        // 构造删除条件
        QueryWrapper<WorkerEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("WORKERID", workerids);
        boolean remove = workerService.remove(queryWrapper);
        if (remove) {
            return R.ok();
        }
        return R.error("删除失败");
    }

}
