package com.zckj.sys.entity;

import lombok.Data;

import java.util.Map;

@Data
public class Result {
	/**编号 */
	private String id;
	/**信息 */
	private String info;
	/**参数*/
	private Map<String,String> param;

	public void init() {
		this.id="0";
		this.info="";
	}

	
}
