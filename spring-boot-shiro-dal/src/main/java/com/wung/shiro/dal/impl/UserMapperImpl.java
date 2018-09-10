/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.dal.impl;

import com.wung.shiro.dal.UserMapper;
import com.wung.shiro.model.Resource;
import com.wung.shiro.model.Role;
import com.wung.shiro.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wung 2018/9/7.
 */
@Repository
public class UserMapperImpl implements UserMapper {
	
	@Override
	public User findByUserName(String userName) {
		return createUserByUserName(userName);
	}
	
	private User createUserByUserName(String userName) {
		if ("wung".equals(userName)) {
			User user = new User();
			user.setId(1);
			user.setUserName(userName);
			user.setRealName("王二");
			user.setPassword("123");
			user.setRoles(createRolesByUserName(userName));
			return user;
		}
		
		User user = new User();
		user.setId(2);
		user.setUserName(userName);
		user.setRealName("李四");
		user.setPassword("1234");
		user.setRoles(createRolesByUserName(userName));
		return user;
	}
	
	private Set<Role> createRolesByUserName(String userName) {
		Set<Role> roles = new HashSet<>();
		if ("wung".equals(userName)) {
			Role role = new Role();
			role.setId(1);
			role.setRoleName("admin");
			role.setResources(createResourcesByRoleId(1));
			roles.add(role);
			return roles;
		}
		
		Role role = new Role();
		role.setId(2);
		role.setRoleName("staff");
		role.setResources(createResourcesByRoleId(2));
		roles.add(role);
		return roles;
	}
	
	private Set<Resource> createResourcesByRoleId(Integer roleId) {
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
}
