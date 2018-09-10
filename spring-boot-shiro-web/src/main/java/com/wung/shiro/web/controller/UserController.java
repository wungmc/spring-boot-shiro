/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.web.controller;

import com.wung.shiro.model.User;
import com.wung.shiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public String addUser(User user) {
		System.out.println("add user:" + user);
		return "success";
	}
	
	
	@RequestMapping("/delete")
	@RequiresPermissions("user:delete")
	public String deleteUser(Integer id) {
		System.out.println("delete user:" + id);
		return "success";
	}
	
	
	@RequestMapping("/update")
	@RequiresPermissions("user:update")
	public String updateUser(Integer id, String realName) {
		System.out.println("update user: id=" + id + ",realName={}" + realName);
		return "success";
	}
	
	
	@RequestMapping("/query")
	@RequiresPermissions("user:query")
	public String findUser(String userName) {
		System.out.println("query user:" + userName);
		User user = userService.findByUserName(userName);
		System.out.println("查询结果：" + user);
		return "success";
	}
	
	
}
