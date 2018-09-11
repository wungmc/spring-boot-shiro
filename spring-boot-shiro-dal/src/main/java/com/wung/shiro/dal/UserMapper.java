/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.dal;

import com.wung.shiro.model.Resource;
import com.wung.shiro.model.Role;
import com.wung.shiro.model.User;

import java.util.Set;

/**
 *
 * @author wung 2018/9/7.
 */
public interface UserMapper {
	
	User findByUserName(String userName);
	
	Set<Role> findRoleByUserId(Integer id);
	
	Set<Resource> findResourceByRoleId(Integer id);
	
}
