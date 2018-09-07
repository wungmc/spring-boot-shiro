/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.service;

import com.wung.shiro.model.User;

/**
 * @author wung 2018/9/7.
 */
public interface UserService {
	
	User findByUserName(String userName);
	
}
