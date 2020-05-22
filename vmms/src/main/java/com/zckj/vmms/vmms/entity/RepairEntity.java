package com.zckj.vmms.vmms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 维修订单
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-22 16:42:59
 */
@Data
@TableName("t_repair")
public class RepairEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String repairId;
	/**
	 * 
	 */
	private String partId;
	/**
	 * 
	 */
	private String carNumber;
	/**
	 * 
	 */
	private String company;
	/**
	 * 
	 */
	private String place;
	/**
	 * 
	 */
	private String beforePhoto;
	/**
	 * 
	 */
	private String processPhoto;
	/**
	 * 
	 */
	private String damagedPart;
	/**
	 * 
	 */
	private Date gmtCreated;

}
