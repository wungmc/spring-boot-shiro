/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.service.impl;

import com.wung.shiro.dal.UserMapper;
import com.wung.shiro.model.Resource;
import com.wung.shiro.model.Role;
import com.wung.shiro.model.User;
import com.wung.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * @author wung 2018/9/7.
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Optional<User> findByUserName(String userName) {
		return Optional.ofNullable(userMapper.findByUserName(userName));
	}
	
	@Override
	public Set<Role> findRoleByUserId(Integer userId) {
		return userMapper.findRoleByUserId(userId);
	}
	
	@Override
	public Set<Resource> findResourceByRoleId(Integer roleId) {
		return userMapper.findResourceByRoleId(roleId);
	}
	
}
