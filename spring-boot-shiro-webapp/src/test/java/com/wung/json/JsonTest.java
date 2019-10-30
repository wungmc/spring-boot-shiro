/*
 * Copyright (C), 2011-2019.
 */
package com.wung.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;
import org.junit.Test;

/**
 * @author wung 2019-10-30.
 */
public class JsonTest {
	
	@Test
	public void generateJson() {
		ReqeustObj reqeustObj = new ReqeustObj();
		ServiceObj serviceObj = new ServiceObj();
		ServiceHeader serviceHeader = new ServiceHeader();
		
		ServiceBody serviceBody = new ServiceBody();
		SignIdApplyParam signIdApplyParam = new SignIdApplyParam();
		serviceBody.setRequest(signIdApplyParam);
		
		serviceObj.setServiceHeader(serviceHeader);
		serviceObj.setServiceBody(serviceBody);
		reqeustObj.setService(serviceObj);
		
		SerializeConfig config = new SerializeConfig();
		config.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
		String requestJson = JSON.toJSONString(reqeustObj, config);
		
		JSONObject requestJson2 = new JSONObject();
		requestJson2.put("SERVICE", serviceObj);
		
		System.out.println(requestJson);
		System.out.println(requestJson2);
	}
}
