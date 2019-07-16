/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author wung 2018/9/6.
 */
@Controller
public class IndexController {
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "mark");
		return "hello";
	}
	
	@RequestMapping("/index")
	@ResponseBody
	public String index(Integer id) {
		return "id=" + id;
	}
	
	
}
