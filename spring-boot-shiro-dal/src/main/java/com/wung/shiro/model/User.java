/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author wung 2018/9/7.
 */
@Data
public class User implements Serializable {
	
	private static final long serialVersionUID = 3257452786440484425L;
	
	private Integer id;
	
	private String userName;
	
	
	private String password;
	
	private String realName;
	
	private Set<Role> roles;
}
