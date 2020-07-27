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
@TableName("WORKER")
public class WorkerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 单位编号
	 */
	@TableId
	private String orgno;
	/**
	 * 操作员编号
	 */
	private String workerid;
	/**
	 * 操作员姓名
	 */
	private String workername;
	/**
	 * 登录帐号
	 */
	private String code;
	/**
	 * 密码
	 */
	private String pwd;
	/**
	 * 权限
	 */
	private String roleid;
	/**
	 * 证件编号
	 */
	private String idcard;
	/**
	 * 电话
	 */
	private String tele;
	/**
	 * 状态
	 */
	private String state;
	/**
	 * 岗位
	 */
	private String gw;
	/**
	 * 部门
	 */
	private String wgno;
	/**
	 * 首页
	 */
	private String home;
	/**
	 * 是否发送短信
	 */
	private String sms;

}
