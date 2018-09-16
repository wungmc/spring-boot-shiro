/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.web.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 *
 * @author wung 2018/9/16.
 */
@Slf4j
@Component
public class TestTask {
	
	@Scheduled(cron = "*/5 * * * * *")
	public void run1() {
		log.info("定时任务run1() 运行...");
	}
	
}
