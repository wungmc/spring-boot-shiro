/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * 发送消息
 *
 * @author wung 2018/9/19.
 */
@Component
public class MessageProducer {
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	public String sendMessage(Destination destination, final String msg) {
			jmsMessagingTemplate.convertAndSend(destination, msg);
			return "success";
	}
	
}
