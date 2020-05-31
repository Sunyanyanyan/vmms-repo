package com.zckj.vmms.vmms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 维修清单详情
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
@Data
@TableName("t_detail")
@ApiModel(value = "维修清单详情")
public class DetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 维修清单主键编号
	 */
	@TableId
	@ApiModelProperty(value = "维修清单主键编号")
	private Integer detailId;
	/**
	 * 所属工单编号（自动生成）
	 */
	@ApiModelProperty(value = "所属工单编号(外键)")
	private Integer orderId;
	/**
	 * 项目名称
	 */
	@ApiModelProperty(value = "项目名称")
	private String item;
	/**
	 * 项目费用
	 */
	@ApiModelProperty(value = "项目费用")
	private BigDecimal itemBill;

}
