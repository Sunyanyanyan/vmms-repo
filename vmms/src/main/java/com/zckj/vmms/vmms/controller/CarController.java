package com.zckj.vmms.vmms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.R;
import com.zckj.vmms.vmms.entity.CarEntity;
import com.zckj.vmms.vmms.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 车牌号表
 *
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
@RestController
@RequestMapping("vmms/car")
@Api(tags = {"车牌号接口"})
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 根据单位编号查询车牌号
     */
    @GetMapping("/findByRegionNumber")
    @ApiOperation(value = "根据单位编号regionNumber查询车牌号")
    @ApiImplicitParam(name = "regionNumber", value = "单位编号", required = true)
    public R findByRegionNumber(CarEntity car) {
        String regionNumber = car.getRegionNumber();
        QueryWrapper<CarEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("region_number",regionNumber);
        List<CarEntity> list = carService.list(queryWrapper);
        if (list.size()>0) {
            return R.ok().put("list",list);
        }
        return R.error("查询信息不存在");
    }


    /**
     * 信息
     */
    @GetMapping("/info/{carId}")
    public R info(@PathVariable("carId") String carId) {
        CarEntity car = carService.getById(carId);

        return R.ok().put("car", car);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(CarEntity car) {
        carService.save(car);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(CarEntity car) {
        carService.updateById(car);

        return R.ok();
    }

    /**
     * 删除
     */
//    @DeleteMapping("/delete")
//    public R delete(@RequestBody String[] carIds){
//		carService.removeByIds(Arrays.asList(carIds));
//
//        return R.ok();
//    }

}
