package com.zckj.vmms.vmms.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 维修工单
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-27 09:54:06
 */
@Data
@TableName("t_order")
@ApiModel(value = "维修工单")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键编号（自动生成）
	 */
	@TableId
	@ApiModelProperty(name = "orderId", value = "主键编号", dataType = "Integer")
	private Integer orderId;
	/**
	 * 维修厂编号
	 */
	@ApiModelProperty(name = "shopId", value = "维修厂编号", dataType = "Integer")
	private Integer shopId;
	/**
	 * 车牌号（主键）
	 */
	@ApiModelProperty(name = "carId", value = "车牌号", dataType = "String")
	private String carId;
	/**
	 * 车辆所属单位编号（自动获取）
	 */
	@ApiModelProperty(name = "regionNumber", value = "车辆所属单位编号", dataType = "String")
	private String regionNumber;
	/**
	 * 申请时间（自动获取）
	 */
	@ApiModelProperty(name = "applicationTime", value = "申请时间", dataType = "String")
	@TableField(value = "application_time",fill = FieldFill.INSERT)
	private String applicationTime;
	/**
	 * 申请人姓名（自动获取）
	 */
	@ApiModelProperty(name = "name", value = "申请人姓名", dataType = "String")
	private String name;
	/**
	 * 申请人编号（自动获取）
	 */
	@ApiModelProperty(name = "applicantNumber", value = "申请人编号", dataType = "String")
	private String applicantNumber;
	/**
	 * 状态[待审批；不同意；待修理；修理中；修理完成]
	 */
	@ApiModelProperty(name = "status", value = "状态[待审批；不同意；待修理；修理中；修理完成]", dataType = "String")
	private String status;
	/**
	 * 维修性质[可选：保养、维修、装饰、其他]
	 */
	@ApiModelProperty(name = "attribute", value = "维修性质[保养、维修、装饰、其他]", dataType = "String")
	private String attribute;
	/**
	 * 维修前照片
	 */
	@ApiModelProperty(name = "beforeImgUrl", value = "维修前照片", dataType = "String")
	private String beforeImgUrl;
	/**
	 * 维修后照片
	 */
	@ApiModelProperty(name = "afterImgUrl", value = "维修后照片", dataType = "String")
	private String afterImgUrl;
	/**
	 * 损坏件照片
	 */
	@ApiModelProperty(name = "damageImgUrl", value = "损坏件照片", dataType = "String")
	private String damageImgUrl;
	/**
	 * 故障描述（非必填）
	 */
	@ApiModelProperty(name = "description", value = "故障描述（非必填）", dataType = "String")
	private String description;
	/**
	 * 维修开始时间
	 */
	@ApiModelProperty(name = "startTime", value = "维修开始时间", dataType = "String")
	private String startTime;
	/**
	 * 维修结束时间
	 */
	@ApiModelProperty(name = "endTime", value = "维修结束时间", dataType = "String")
	private String endTime;
	/**
	 * PC端导出时更改导出标志[0-未导出；1-导出]
	 */
	@ApiModelProperty(name = "exportStatus", value = "导出标志[0-未导出；1-导出]", dataType = "Integer")
	private Integer exportStatus;
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
