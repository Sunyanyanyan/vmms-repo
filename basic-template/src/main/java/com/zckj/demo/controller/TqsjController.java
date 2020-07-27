package com.zckj.demo.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zckj.demo.entity.TqsjEntity;
import com.zckj.demo.service.TqsjService;
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
@RequestMapping("demo/tqsj")
public class TqsjController {
    @Autowired
    private TqsjService tqsjService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tqsjService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{rq}")
    public R info(@PathVariable("rq") String rq){
		TqsjEntity tqsj = tqsjService.getById(rq);

        return R.ok().put("tqsj", tqsj);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TqsjEntity tqsj){
		tqsjService.save(tqsj);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TqsjEntity tqsj){
		tqsjService.updateById(tqsj);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] rqs){
		tqsjService.removeByIds(Arrays.asList(rqs));

        return R.ok();
    }

}
