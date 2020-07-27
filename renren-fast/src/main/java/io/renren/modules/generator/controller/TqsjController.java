package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.TqsjEntity;
import io.renren.modules.generator.service.TqsjService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 台区数据
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
@RestController
@RequestMapping("generator/tqsj")
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
