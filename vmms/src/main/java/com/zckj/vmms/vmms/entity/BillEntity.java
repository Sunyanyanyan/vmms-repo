package com.zckj.vmms.vmms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 报账费用
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-05-22 16:42:59
 */
@Data
@TableName("t_bill")
public class BillEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String billId;
	/**
	 * 
	 */
	private BigDecimal repairBill;
	/**
	 * 
	 */
	private BigDecimal partBill;

}
