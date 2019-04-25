/*
 * Copyright (C), 2011-2018.
 */
package com.wung.shiro.web.config;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author wung 2018/9/10.
 */
@ControllerAdvice
public class GlobalExceptionResolver {
	
	@ExceptionHandler(value = UnauthorizedException.class)
	@ResponseBody
	public Result unauthorizedExceptionHandler() {
		return Result.failed(ResultCodes.USER_UNAUTHORIZED);
	}
	
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result exceptionHandler() {
		return Result.failed(ResultCodes.SYS_EXCEPTION);
	}
	
	
}
