/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.web.controller;

import com.wung.shiro.model.User;
import com.wung.shiro.service.UserService;
import com.wung.shiro.web.config.Result;
import com.wung.shiro.web.config.ResultCodes;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author wung 2018/9/10.
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/add")
	@RequiresPermissions("user:add")
	public Result<Integer> addUser(User user) {
		System.out.println("add user:" + user);
		return Result.success(3);
		
	}
	
	@RequestMapping("/delete")
	@RequiresPermissions("user:delete")
	@RequiresRoles(value = "admin")
	public Result<Boolean> deleteUser(Integer id) {
		System.out.println("delete user:" + id);
		return Result.success(true);
		
	}
	
	
	@RequestMapping("/update")
	@RequiresPermissions("user:update")
	public Result<Boolean> updateUser(Integer id, String realName) {
		System.out.println("update user: id=" + id + ",realName={}" + realName);
		return Result.success(true);
	}
	
	
	@RequestMapping("/query")
	@RequiresPermissions("user:query")
	public Result<User> findUser(String userName) {
		System.out.println("query user:" + userName);
		Optional<User> userOptional = userService.findByUserName(userName);
		System.out.println("查询结果：" + userOptional);
		
		return userOptional.map(Result::success).orElseGet(() -> Result.failed(ResultCodes.DB_NOT_EXISTS));
	}
	
	
}
