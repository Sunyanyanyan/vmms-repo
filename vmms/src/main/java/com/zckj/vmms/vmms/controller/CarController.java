package com.zckj.vmms.vmms.controller;

import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.R;
import com.zckj.vmms.vmms.entity.CarEntity;
import com.zckj.vmms.vmms.service.CarService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = carService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{carId}")
    public R info(@PathVariable("carId") String carId){
		CarEntity car = carService.getById(carId);

        return R.ok().put("car", car);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CarEntity car){
		carService.save(car);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody CarEntity car){
		carService.updateById(car);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody String[] carIds){
		carService.removeByIds(Arrays.asList(carIds));

        return R.ok();
    }

}
