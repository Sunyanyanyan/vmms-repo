package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 台区数据
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-11 12:20:43
 */
@Data
@TableName("TQSJ")
public class TqsjEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 日期：2020-06-06日，2020-06月
	 */
	@TableId
	private String rq;
	/**
	 * 单位编号
	 */
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
	 * 台区类型
	 */
	private String tqlx;
	/**
	 * 台区经理编号
	 */
	private String tqjlbh;
	/**
	 * 台区经理名称
	 */
	private String tqjlxm;
	/**
	 * 供电量
	 */
	private Integer gdl;
	/**
	 * 月均供电量
	 */
	private Integer pjgdl;
	/**
	 * 售电量
	 */
	private Integer sdl;
	/**
	 * 线损率
	 */
	private Integer xsl;
	/**
	 * 线损情况：A、B、C、D四个等级
	 */
	private String xsqk;
	/**
	 * 应抄户数
	 */
	private String ychs;
	/**
	 * 采集成功户数
	 */
	private String schs;
	/**
	 * 采集成功率
	 */
	private Integer cjcgl;
	/**
	 * 停电次数
	 */
	private Integer tdcs;
	/**
	 * 停电时长
	 */
	private Integer tdsc;
	/**
	 * 电费回收率
	 */
	private Integer dfhsl;
	/**
	 * 负载情况
	 */
	private String fzqk;
	/**
	 * 是否三相不平衡
	 */
	private String sxbph;
	/**
	 * 停复电成功率
	 */
	private Integer tfdcgl;
	/**
	 * 低电压户数
	 */
	private Integer ddyhs;
	/**
	 * 基础数据正确率
	 */
	private Integer jcsjzql;
	/**
	 * 钱流程应用率
	 */
	private Integer qlcyyl;
	/**
	 * 业扩时限达标率
	 */
	private Integer yksxdbl;
	/**
	 * 投诉工单数
	 */
	private Integer tsgds;
	/**
	 * 台区容量
	 */
	private Integer cap;

}
