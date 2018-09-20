/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.service.impl;

import com.wung.shiro.dal.UserMapper;
import com.wung.shiro.model.User;
import com.wung.shiro.service.UserAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author wung 2018/9/7.
 */
@Service
public class UserAsyncServiceImpl implements UserAsyncService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Async
	public Future<List<User>> asynFindAll() {
		long start = System.currentTimeMillis();
		
		System.out.println("开始查询...");
		List<User> list = userMapper.findAll();
		System.out.println("查询结束. 耗时：" + (System.currentTimeMillis() - start));
		return new AsyncResult<>(list);
	}
	
}
