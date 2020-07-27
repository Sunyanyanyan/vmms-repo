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
@TableName("DIM_CST_TG_CZ_TEST")
public class DimCstTgCzTestEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private String tgId;
	/**
	 * $column.comments
	 */
	private String tgOrgNo;
	/**
	 * $column.comments
	 */
	private String tgOrgNm;
	/**
	 * $column.comments
	 */
	private String contyOrgNo;
	/**
	 * $column.comments
	 */
	private String contyOrgNm;
	/**
	 * $column.comments
	 */
	private String cityOrgNo;
	/**
	 * $column.comments
	 */
	private String cityOrgNm;
	/**
	 * $column.comments
	 */
	private String provcOrgNo;
	/**
	 * $column.comments
	 */
	private String provcOrgNm;
	/**
	 * $column.comments
	 */
	private String tgNo;
	/**
	 * $column.comments
	 */
	private String tgNm;
	/**
	 * $column.comments
	 */
	private Integer cap;
	/**
	 * $column.comments
	 */
	private String instAddr;
	/**
	 * $column.comments
	 */
	private Date chgTm;
	/**
	 * $column.comments
	 */
	private String pubPrivFlg;
	/**
	 * $column.comments
	 */
	private String pubPrivDsc;
	/**
	 * $column.comments
	 */
	private String runSt;
	/**
	 * $column.comments
	 */
	private String runStDsc;
	/**
	 * $column.comments
	 */
	private String lineNo;
	/**
	 * $column.comments
	 */
	private String lineNm;
	/**
	 * $column.comments
	 */
	private String pmsLineId;
	/**
	 * $column.comments
	 */
	private String stdTgOrgNo;
	/**
	 * $column.comments
	 */
	private String stdTgOrgNm;
	/**
	 * $column.comments
	 */
	private String stdContyOrgNo;
	/**
	 * $column.comments
	 */
	private String stdContyOrgNm;
	/**
	 * $column.comments
	 */
	private String stdCityOrgNo;
	/**
	 * $column.comments
	 */
	private String stdCityOrgNm;
	/**
	 * $column.comments
	 */
	private String stdProvcOrgNo;
	/**
	 * $column.comments
	 */
	private String stdProvcOrgNm;
	/**
	 * $column.comments
	 */
	private String dataDt;
	/**
	 * $column.comments
	 */
	private Date etlTm;

}
