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
@TableName("ROLE")
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 岗位编号
	 */
	@TableId
	private String roleid;
	/**
	 * 模块编号
	 */
	private Integer moduleid;
	/**
	 * 岗位名称
	 */
	private String rolename;
	/**
	 * 等级
	 */
	private Integer grade;
	/**
	 * 序号
	 */
	private Integer ordid;

}
