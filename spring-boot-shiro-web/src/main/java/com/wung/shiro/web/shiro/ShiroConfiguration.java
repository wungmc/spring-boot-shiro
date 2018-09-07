/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.web.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @author wung 2018/9/7.
 */
// @Configuration
public class ShiroConfiguration {
	
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		
		bean.setSecurityManager(securityManager);
		// 配置登录页面
		bean.setLoginUrl("/login");
		// 配置登录成功后跳转的页面
		bean.setSuccessUrl("/index");
		
		// 配置访问权限
		// 注意：过滤链需要保证有序，所以使用 LinkedHashMap
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>(){{
			// 表示可匿名访问
			put("/jsp/login.jsp", "anon");
			// put("/loginUser", "anon");
			// put("/logout*","anon");
			// put("/jsp/error.jsp*","anon");
			// put("/jsp/index.jsp*","authc");
			// //表示需要认证才可以访问
			// put("/*", "authc");
			// //表示需要认证才可以访问
			// put("/**", "authc");
			// put("/*.*", "authc");
		}};
		// 上面的 anon, authc 等都是固定的名称，指代shiro提供的过滤器
		
		bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return bean;
	}
	
	/**
	 * 核心安全事务管理器
	 *
	 */
	@Bean
	public SecurityManager securityManager(AuthRealm authRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(authRealm);
		return securityManager;
	}
	
	
	@Bean
	public AuthRealm authRealm(CredentialsMatcher credentialsMatcher) {
		AuthRealm authRealm = new AuthRealm();
		authRealm.setCredentialsMatcher(credentialsMatcher);
		return authRealm;
	}
	
	/**
	 * 自定义密码比较器
	 * @return
	 */
	@Bean
	public CredentialsMatcher credentialsMatcher() {
		return new CredentialsMatcher();
	}
	
	/**
	 * Shiro生命周期处理器
	 * @return
	 */
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
	
	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
		return defaultAdvisorAutoProxyCreator;
	}
	
	/**
	 * 权限注解起作用
	 *
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
	
	
}
