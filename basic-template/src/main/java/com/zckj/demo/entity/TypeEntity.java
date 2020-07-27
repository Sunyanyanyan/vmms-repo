package com.zckj.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ${comments}
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-10 20:14:07
 */
@Data
@TableName("TYPE")
public class TypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private String orgno;
	/**
	 * $column.comments
	 */
	private String name;
	/**
	 * $column.comments
	 */
	private String note;
	/**
	 * $column.comments
	 */
	private String tj;
	/**
	 * $column.comments
	 */
	private Integer ordid;

}
