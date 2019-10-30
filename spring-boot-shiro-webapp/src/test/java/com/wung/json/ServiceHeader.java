/*
 * Copyright (C), 2011-2019.
 */
package com.wung.json;

import lombok.Data;

/**
 * 请求头信息
 *
 * @author wung 2019-10-30.
 */
@Data
public class ServiceHeader {
	private String VERSION_ID;
	private String SERVICE_ID;
	private String ORG;
	private String SERVICESN;
	private String RESSERVICESN;
	private String CHANNEL_ID;
	private String SUB_TERMINAL_TYPE;
	private String OP_ID;
	private String REQUEST_TIME;
	private String RESSERVICETIME;
	private String MAC;
	
}
