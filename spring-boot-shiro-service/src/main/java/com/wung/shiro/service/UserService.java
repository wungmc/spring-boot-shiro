/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.service;

import com.wung.shiro.model.Resource;
import com.wung.shiro.model.Role;
import com.wung.shiro.model.User;

import java.util.Optional;
import java.util.Set;

/**
 * @author wung 2018/9/7.
 */
public interface UserService {
	
	Optional<User> findByUserName(String userName);
	
	Set<Role> findRoleByUserId(Integer userId);
	
	Set<Resource> findResourceByRoleId(Integer roleId);
	
}
