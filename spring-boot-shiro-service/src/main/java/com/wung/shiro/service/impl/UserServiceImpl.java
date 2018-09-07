/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.service.impl;

import com.wung.shiro.dal.UserMapper;
import com.wung.shiro.model.User;
import com.wung.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wung 2018/9/7.
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findByUserName(String userName) {
		return userMapper.findByUserName(userName);
	}
	
}
