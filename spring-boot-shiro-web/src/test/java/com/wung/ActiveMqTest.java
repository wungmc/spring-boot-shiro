/*
 * Copyright (C), 2011-2018.
 */
package com.wung;

import com.wung.shiro.activemq.MessageProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

/**
 * @author wung 2018/9/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMqTest {
	
	@Autowired
	private MessageProducer messageProducer;
	
	@Test
	public void message() {
		Destination destination = new ActiveMQQueue("mq.test");
		String result = messageProducer.sendMessage(destination, "hello world");
		assert result.equals("success");
	}
}


