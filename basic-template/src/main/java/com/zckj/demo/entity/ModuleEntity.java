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
@TableName("MODULE")
public class ModuleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 模块编号
	 */
	@TableId
	private Integer moduleid;
	/**
	 * 模块名称
	 */
	private String modulename;
	/**
	 * 文件名（web项目不用填）
	 */
	private String filename;
	/**
	 * 页面（窗体）路径
	 */
	private String formname;
	/**
	 * 序号
	 */
	private Integer ordid;
	/**
	 * 分类
	 */
	private String parent;
	/**
	 * 等级
	 */
	private Integer grade;
	/**
	 * 图标文件
	 */
	private String icon;

}
