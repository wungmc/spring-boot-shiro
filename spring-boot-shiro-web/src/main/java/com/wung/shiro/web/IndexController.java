/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wung 2018/9/6.
 */
@RestController
public class IndexController {
	
	@RequestMapping("/hello")
	public String hello(String name) {
		return "hello, " + name;
	}
	
}
