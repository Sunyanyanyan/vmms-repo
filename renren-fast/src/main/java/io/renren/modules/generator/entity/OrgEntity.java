package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * ORG
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
@Data
@TableName("ORG")
public class OrgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 单位编号
	 */
	@TableId
	private String orgno;
	/**
	 * 单位名称
	 */
	private String orgname;
	/**
	 * 类型
	 */
	private String orgtype;
	/**
	 * 上级编号
	 */
	private String parentno;
	/**
	 * 等级
	 */
	private Integer grade;
	/**
	 * 经度
	 */
	private Integer pointX;
	/**
	 * 纬度
	 */
	private Integer pointY;
	/**
	 * 备注
	 */
	private String note;

	@TableField(exist=false)	// 标注不是表里面的属性，自定义属性
	private List<OrgEntity> children;

}
