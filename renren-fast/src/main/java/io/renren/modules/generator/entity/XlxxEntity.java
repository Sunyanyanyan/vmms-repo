package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 线路信息
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
@Data
@TableName("XLXX")
public class XlxxEntity implements Serializable {
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
	 * 变电站编号
	 */
	private String gisElecStatNo;
	/**
	 * 变电站名称
	 */
	private String gisElecStatNm;
	/**
	 * 线路ID，唯一
	 */
	private String linePkId;
	/**
	 * 营销系统线路编号
	 */
	private String cmsLineId;
	/**
	 * 线路名称
	 */
	private String lineNm;
	/**
	 * 线路长度
	 */
	private Integer lineLen;
	/**
	 * 投运时间
	 */
	private String shipDt;
	/**
	 * 设备主人编号
	 */
	private String sbzrbh;
	/**
	 * 设备主人姓名
	 */
	private String sbzrxm;

}
