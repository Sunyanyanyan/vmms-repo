package com.zckj.vmms.vmms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 车牌号表
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
@Data
@TableName("t_car")
public class CarEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 车牌号（主键）
	 */
	@TableId
	@ApiModelProperty(name = "carId", value = "车牌号", dataType = "String")
	private String carId;
	/**
	 * 单位编号
	 */
	private String regionNumber;

}
