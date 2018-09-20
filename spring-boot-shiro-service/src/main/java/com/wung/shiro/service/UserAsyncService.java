/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.service;

import com.wung.shiro.model.User;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author wung 2018/9/7.
 */
public interface UserAsyncService {
	
	/**
	 * 异步查询所有用户
	 *
	 * @return
	 */
	Future<List<User>> asynFindAll();
	
}
