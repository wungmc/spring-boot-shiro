/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.web.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * 密码验证
 * 一般情况可以使用预定义的 HashedCredentialsMatcher 对密码进行加密处理
 *
 * @author wung 2018/9/7.
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		UsernamePasswordToken uToken = (UsernamePasswordToken) token;
		
		// 输入的密码
		String inputPassword = String.valueOf(uToken.getPassword());
		// 真实密码
		String realPassword = (String) info.getCredentials();
		
		// 比对密码
		return realPassword.equals(inputPassword);
	}
	
}