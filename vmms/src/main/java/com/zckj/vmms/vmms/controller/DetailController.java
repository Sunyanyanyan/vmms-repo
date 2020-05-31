package com.zckj.vmms.vmms.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "维修清单详情接口")
public class DetailController {
    @Autowired
    private DetailService detailService;

    /**
     * 修改
     */
    @PutMapping(value = "/update", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "根据维修清单id更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "detailId", value = "主键", dataType = "Integer",required = true),
            @ApiImplicitParam(name = "item", value = "项目名称", dataType = "String"),
            @ApiImplicitParam(name = "itemBill", value = "项目费用", dataType = "BigDecimal")
    })
    public R update(/*@RequestBody*/ DetailEntity detail){
        boolean flag = detailService.updateById(detail);

        if (flag){
            return R.ok("更新成功");
        }
        return R.error("更新失败");
    }

//    @GetMapping("/test")
//    public R testByWrapper() {
//
//        detailService.testByWrapper();
//
//        return R.ok();
//    }

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
//    @PostMapping(value = "/save", produces = {"application/json;charset=UTF-8"})
//    @ApiOperation(value = "维修清单")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "item", value = "项目名称", dataType = "String"),
//            @ApiImplicitParam(name = "itemBill", value = "项目费用", dataType = "BigDecimal")
//    })
//    public R saveDetail(/*@RequestBody */DetailEntity detail){
//		detailService.saveDetail(detail);
//
//        return R.ok();
//    }



    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Integer[] detailIds){
		detailService.removeByIds(Arrays.asList(detailIds));

        return R.ok();
    }

}
