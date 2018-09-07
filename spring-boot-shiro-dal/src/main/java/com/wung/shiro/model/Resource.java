/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 资源
 *
 * @author wung 2018/9/7.
 */
@Data
public class Resource implements Serializable {
	private static final long serialVersionUID = -8571937351912906815L;
	
	private Integer id;
	
	private String perm;
	
	private String desc;
	
}
