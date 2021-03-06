/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.web.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
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
@Configuration
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
			put("/login", "anon");
			put("/loginUser", "anon");
			put("/logout","authc");
			put("/user/**", "authc");
			// //表示需要认证才可以访问
			put("/*", "authc");
			// //表示需要认证才可以访问
			put("/**", "authc");
			// put("/*.*", "authc");
		}};
		// 上面的 anon, authc 等都是固定的名称，指代shiro提供的过滤器
		// 这里只配置是否需要权限，例如：/user下的接口都需要授权，
		// 但是具体某个接口需要什么授权，是在接口上使用 @RequiresPermissions 来控制的。
		
		bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return bean;
	}
	
	/**
	 * 核心安全事务管理器
	 *
	 */
	@Bean
	public SecurityManager securityManager(AuthRealm authRealm, EhCacheManager ehCacheManager) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(authRealm);
		
		// 使用缓存
		securityManager.setCacheManager(ehCacheManager);
		return securityManager;
	}
	
	
	@Bean
	public AuthRealm authRealm(HashedCredentialsMatcher hashedCredentialsMatcher) {
		AuthRealm authRealm = new AuthRealm();
		authRealm.setCredentialsMatcher(hashedCredentialsMatcher);
		return authRealm;
	}
	
	/**
	 * 自定义密码比较器
	 * @return
	 */
	// @Bean
	// public CredentialsMatcher credentialsMatcher() {
	// 	return new CredentialsMatcher();
	// }
	
	/**
	 * 也可以使用预定义的 HashedCredentialsMatcher，这个类是为了对密码进行编码的，
	 * 防止密码在数据库里明码保存，当然在登陆认证的时候，
	 * 这个类也负责对form里输入的密码进行编码。
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		credentialsMatcher.setHashAlgorithmName("MD5");
		return credentialsMatcher;
	}
	
	/**
	 * 缓存初始化定义
	 */
	@Bean
	public EhCacheManager ehCacheManager() {
		EhCacheManager ehCacheManager = new EhCacheManager();
		ehCacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
		return ehCacheManager;
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
