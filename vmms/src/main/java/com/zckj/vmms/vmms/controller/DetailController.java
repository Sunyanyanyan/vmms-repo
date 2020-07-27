package com.zckj.vmms.vmms.controller;

import com.zckj.vmms.utils.R;
import com.zckj.vmms.vmms.entity.DetailEntity;
import com.zckj.vmms.vmms.service.DetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * 维修清单详情
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
@RestController
@RequestMapping("vmms/detail")
@Api(tags = "维修清单接口")
public class DetailController {

    @Autowired
    private DetailService detailService;

    /**
     * 修改
     */
    @PutMapping(value = "/update", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "根据维修清单主键detailId更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "detailId", value = "主键", dataType = "Integer"),
            @ApiImplicitParam(name = "item", value = "项目名称", dataType = "String"),
            @ApiImplicitParam(name = "itemBill", value = "项目费用", dataType = "BigDecimal")
    })
    public R updateDetail(DetailEntity detail) {
        boolean flag = detailService.updateById(detail);

        if (flag) {
            return R.ok("更新成功");
        }
        return R.error("更新失败");
    }


    /**
     * 列表
     */
//    @GetMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = detailService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


    /**
     * 信息
     */
    @GetMapping("/info/{detailId}")
    public R infoDetail(@PathVariable("detailId") Integer detailId) {
        DetailEntity detail = detailService.getById(detailId);

        return R.ok().put("detail", detail);
    }


    /**
     * 删除
     */
//    @DeleteMapping("/delete")
//    public R delete(@RequestBody Integer[] detailIds) {
//        detailService.removeByIds(Arrays.asList(detailIds));
//
//        return R.ok();
//    }

}
