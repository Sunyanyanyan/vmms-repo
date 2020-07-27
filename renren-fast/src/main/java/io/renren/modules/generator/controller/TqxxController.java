package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.TqxxEntity;
import io.renren.modules.generator.service.TqxxService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 台区信息
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
@RestController
@RequestMapping("generator/tqxx")
public class TqxxController {
    @Autowired
    private TqxxService tqxxService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tqxxService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tgOrgNo}")
    public R info(@PathVariable("tgOrgNo") String tgOrgNo){
		TqxxEntity tqxx = tqxxService.getById(tgOrgNo);

        return R.ok().put("tqxx", tqxx);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TqxxEntity tqxx){
		tqxxService.save(tqxx);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TqxxEntity tqxx){
		tqxxService.updateById(tqxx);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] tgOrgNos){
		tqxxService.removeByIds(Arrays.asList(tgOrgNos));

        return R.ok();
    }

}
