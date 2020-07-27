package com.zckj.vmms.vmms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-02 15:47:24
 */
@Data
@TableName("org")
public class OrgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 申请人编号
	 */
	@TableId
	@ApiModelProperty(name = "applicantId", value = "申请人编号", dataType = "String")
	private String applicantId;
	/**
	 * 申请人姓名
	 */
	@ApiModelProperty(name = "applicantName", value = "申请人姓名", dataType = "String")
	private String applicantName;
	/**
	 * 用户唯一标识
	 */
	@ApiModelProperty(name = "openId", value = "用户唯一标识", dataType = "String")
	private String openId;
	/**
	 * 单位编号
	 */
	@ApiModelProperty(name = "regionNumber", value = "单位编号", dataType = "String")
	private String regionNumber;

}
