/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.dal.impl;

import com.wung.shiro.dal.UserMapper;
import com.wung.shiro.model.Resource;
import com.wung.shiro.model.Role;
import com.wung.shiro.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wung 2018/9/7.
 */
@Repository
public class UserMapperImpl implements UserMapper {
	
	@Override
	public User findByUserName(String userName) {
		System.out.println("数据库查询用户：" + userName);
		return createUserByUserName(userName);
	}
	
	@Override
	public Set<Role> findRoleByUserId(Integer id) {
		System.out.println("数据库查询用户角色：userId=" + id);
		
		Set<Role> roles = new HashSet<>();
		if (id == 1) {
			Role role = new Role();
			role.setId(1);
			role.setRoleName("admin");
			roles.add(role);
			return roles;
		}
		
		Role role = new Role();
		role.setId(2);
		role.setRoleName("staff");
		roles.add(role);
		return roles;
	}
	
	@Override
	public Set<Resource> findResourceByRoleId(Integer roleId) {
		System.out.println("数据库查询角色的资源：roleId=" + roleId);
		
		Set<Resource> resources = new HashSet<>();
		if (roleId == 1) {
			Resource resource = new Resource();
			resource.setId(1);
			resource.setPerm("user:add");
			resource.setDesc("新增用户");
			resources.add(resource);
			
			Resource resource1 = new Resource();
			resource1.setId(2);
			resource1.setPerm("user:delete");
			resource1.setDesc("删除用户");
			resources.add(resource1);
			
			Resource resource2 = new Resource();
			resource2.setId(3);
			resource2.setPerm("user:update");
			resource2.setDesc("修改用户");
			resources.add(resource2);
			
			Resource resource3 = new Resource();
			resource3.setId(4);
			resource3.setPerm("user:query");
			resource3.setDesc("查询用户");
			resources.add(resource3);
			
			return resources;
		}
		
		Resource resource = new Resource();
		resource.setId(1);
		resource.setPerm("user:add");
		resource.setDesc("新增用户");
		resources.add(resource);
		
		Resource resource3 = new Resource();
		resource3.setId(4);
		resource3.setPerm("user:query");
		resource3.setDesc("查询用户");
		resources.add(resource3);
		
		return resources;
	}
	
	private User createUserByUserName(String userName) {
		if ("wung".equals(userName)) {
			User user = new User();
			user.setId(1);
			user.setUserName(userName);
			user.setRealName("王二");
			user.setPassword("123");
			// 模拟数据库的密文（明文是123）
			user.setPassword("202cb962ac59075b964b07152d234b70");
			return user;
		}
		
		// 模拟不存在的账号
		if ("lisi".equals(userName)) {
			return null;
		}
		
		User user = new User();
		user.setId(2);
		user.setUserName(userName);
		user.setRealName("李四");
		user.setPassword("123");
		// 模拟数据库的密文（明文是123）
		user.setPassword("202cb962ac59075b964b07152d234b70");
		return user;
	}
	
	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<>(2);
		User user = new User();
		user.setId(1);
		user.setUserName("wung");
		user.setRealName("王二");
		user.setPassword("123");
		// 模拟数据库的密文（明文是123）
		user.setPassword("202cb962ac59075b964b07152d234b70");
		
		User user1 = new User();
		user1.setId(2);
		user1.setUserName("test");
		user1.setRealName("李四");
		user1.setPassword("123");
		// 模拟数据库的密文（明文是123）
		user1.setPassword("202cb962ac59075b964b07152d234b70");
		
		list.add(user);
		list.add(user1);
		
		try {
			// 睡眠一秒，模拟耗时
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return list;
	}
}
