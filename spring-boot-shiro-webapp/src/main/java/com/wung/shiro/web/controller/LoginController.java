/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.web.controller;

import com.wung.shiro.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author wung 2018/9/7.
 */
@Slf4j
@Controller
public class LoginController {
	
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/loginUser")
	public String loginUser(String userName, String password, HttpSession session) {
		log.info("loginUser(), userName={}, password={}", userName, password);
		
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			// 完成登录(调用AuthRealm.doGetAuthenticationInfo()完成认证)
			subject.login(token);
			User user = (User) subject.getPrincipal();
			session.setAttribute("user", user);
			return "index";
		} catch (Exception e) {
			log.error("loginUser exception", e);
			return "login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}
	
	
}
