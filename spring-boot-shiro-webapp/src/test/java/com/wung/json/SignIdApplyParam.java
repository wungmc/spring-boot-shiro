/*
 * Copyright (C), 2011-2019.
 */
package com.wung.json;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wung 2019-10-30.
 */
@Data
public class SignIdApplyParam implements Serializable {
	
	private static final long serialVersionUID = -3103848998267730801L;
	
	/**
	 * 获取鉴权ID申请编号，唯一
	 */
	private String orderId;
	private String productCode;
	private String custName;
	private String idType;
	private String idNo;
	/**
	 * 添金钱包账号
	 */
	private String cardNo;
	private String phoneNo;
	private String custIp;
	
}
