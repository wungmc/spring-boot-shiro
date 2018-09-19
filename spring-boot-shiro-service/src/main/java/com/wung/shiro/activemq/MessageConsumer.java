/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author wung 2018/9/19.
 */
@Component
public class MessageConsumer {

	@JmsListener(destination = "mq.test")
	public void receiveMsg(String msg) {
		System.out.println("接收到消息：" + msg);
	}
	
}
