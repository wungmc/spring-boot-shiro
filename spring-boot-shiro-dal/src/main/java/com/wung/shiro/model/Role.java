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
public class Role implements Serializable {
	
	private static final long serialVersionUID = -268002927709664390L;
	
	private Integer id;
	
	private String roleName;
	
	private Set<Resource> resources;
	
}
