package com.zckj.vmms.vmms.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 车辆维修申请
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-22 16:42:59
 */
@Data
@TableName("t_apply")
@ApiModel(value = "ApplyEntity对象", description = "申请实体")
public class ApplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(name = "applyId", value = "主键", dataType = "String")
	private String applyId;
	/**
	 * 驾驶员姓名
	 */
	@ApiModelProperty(name = "name", value = "驾驶员姓名", dataType = "String")
	private String name;
	/**
	 * 故障描述
	 */
	@ApiModelProperty(name = "description", value = "故障描述", dataType = "String")
	private String description;
	/**
	 * 维修性质
	 */
	@ApiModelProperty(name = "attribute", value = "维修性质", dataType = "String")
	private String attribute;
	/**
	 * 申请时间
	 */
	@ApiModelProperty(value = "申请时间")
	@TableField(fill = FieldFill.INSERT)
	private Date gmtCreated;

}
