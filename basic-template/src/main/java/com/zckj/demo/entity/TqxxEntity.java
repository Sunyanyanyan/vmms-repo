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
@TableName("TQXX")
public class TqxxEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 单位编号
	 */
	@TableId
	private String tgOrgNo;
	/**
	 * 单位名称
	 */
	private String tgOrgNm;
	/**
	 * 台区ID
	 */
	private String tgId;
	/**
	 * 台区编号
	 */
	private String tgNo;
	/**
	 * 台区名称
	 */
	private String tgNm;
	/**
	 * 容量
	 */
	private Integer cap;
	/**
	 * 地址
	 */
	private String instAddr;
	/**
	 * 投运日期
	 */
	private Date chgTm;
	/**
	 * 台区类型
	 */
	private String pubPrivDsc;
	/**
	 * 状态
	 */
	private String runStDsc;
	/**
	 * 线路编号
	 */
	private String lineNo;
	/**
	 * 线路名称
	 */
	private String lineNm;
	/**
	 * PMS系统线路编号
	 */
	private String pmsLineId;
	/**
	 * 更新日期
	 */
	private String dataDt;
	/**
	 * 台区经理编号
	 */
	private String tqjlbh;
	/**
	 * 台区经理姓名
	 */
	private String tqjlxm;

}
