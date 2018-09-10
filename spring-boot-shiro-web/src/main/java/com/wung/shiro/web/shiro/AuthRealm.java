/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.web.shiro;

import com.wung.shiro.model.Role;
import com.wung.shiro.model.User;
import com.wung.shiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Iterator;

/**
 * 使用shiro必须建立的类。
 * 该类会根据传入的用户名去数据库查询用户信息，并放入shiro中，供密码校验类CredencialsMatchery验证密码。
 *
 * @author wung 2018/9/7.
 */
@Slf4j
public class AuthRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 登录认证
	 * 登录的时候（subject.login(AuthenticationToken)）调用这个方法。
	 *
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户输入的token
		UsernamePasswordToken uToken = (UsernamePasswordToken) token;
		String userName = uToken.getUsername();
		System.out.println("输入的 userName = " + userName + ", password=" + uToken.getPassword());
		
		User user = userService.findByUserName(userName);
		
		//放入shiro.调用CredentialsMatcher检验密码
		return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
	}
	
	/**
	 * 授权.
	 * 如果请求的接口需要授权，则会调用这个方法获取用户的角色及权限集合。
	 * 实际使用时肯定是要加缓存的，避免每次都查库。
	 *
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取session中的用户
		Iterator<User> iterator = principals.fromRealm(getName()).iterator();
		if (!iterator.hasNext()) {
			log.error("无权限");
			return null;
		}
		
		User user = iterator.next();
		
		final SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		user.getRoles().stream()
				.map(Role::getRoleName)
				.forEach(info::addRole);
		user.getRoles().stream()
				.map(Role::getResources)
				.flatMap(Collection::stream)
				.forEach(resource -> info.addStringPermission(resource.getPerm()));
		
		
		return info;
	}
	
}
