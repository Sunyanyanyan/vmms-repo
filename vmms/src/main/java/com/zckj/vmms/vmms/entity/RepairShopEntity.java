package com.zckj.vmms.vmms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 维修厂单表
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
@Data
@TableName("t_repair_shop")
public class RepairShopEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 维修厂编号
	 */
	@TableId
	@ApiModelProperty(name = "shopId", value = "维修厂编号", dataType = "Integer")
	private Integer shopId;
	/**
	 * 维修厂所属单位
	 */
	private String shopRegion;
	/**
	 * 维修厂地址
	 */
	private String shopAddress;
	/**
	 * 维修厂名称
	 */
	private String shopName;
	/**
	 * 经度
	 */
	@ApiModelProperty(name = "longitude", value = "经度", dataType = "BigDecimal")
	private BigDecimal longitude;
	/**
	 * 纬度
	 */
	@ApiModelProperty(name = "latitude", value = "纬度", dataType = "BigDecimal")
	private BigDecimal latitude;

}
