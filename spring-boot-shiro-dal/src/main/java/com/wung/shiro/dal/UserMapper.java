/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.dal;

import com.wung.shiro.model.User;

/**
 *
 * @author wung 2018/9/7.
 */
public interface UserMapper {
	
	User findByUserName(String userName);
	
}
