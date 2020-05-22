package com.zckj.vmms.vmms.controller;

import java.util.Arrays;
import java.util.Map;

import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zckj.vmms.vmms.entity.BillEntity;
import com.zckj.vmms.vmms.service.BillService;



/**
 * 报账费用
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-22 16:42:59
 */
@RestController
@RequestMapping("vmms/bill")
public class BillController {
    @Autowired
    private BillService billService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = billService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{billId}")
    public R info(@PathVariable("billId") String billId){
		BillEntity bill = billService.getById(billId);

        return R.ok().put("bill", bill);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BillEntity bill){
		billService.save(bill);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BillEntity bill){
		billService.updateById(bill);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] billIds){
		billService.removeByIds(Arrays.asList(billIds));

        return R.ok();
    }

}
