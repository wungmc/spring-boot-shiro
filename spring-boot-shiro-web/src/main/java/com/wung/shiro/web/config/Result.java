package com.wung.shiro.web.config;

import lombok.Getter;

import java.io.Serializable;


/**
 * 统一封装返回结果
 *
 */
@Getter
public class Result<T> implements Serializable {


	private static final long serialVersionUID = -8940366960899264819L;

	/** 默认成功的 code 及  msg  */
	protected static final Integer SUCCCESS_CODE = Integer.valueOf(0);
	protected static final String SUCCCESS_MSG = "success";

	/**
	 * 错误代码
	 */
	private Integer code;

	/**
	 * 错误详细信息
	 */
	private String message;

	/**
	 * java 后台判断使用
	 */
	private boolean success = false;

	/**
	 * 返回的数据，调用失败的是，返回数据为null
	 */
	private T data;

	public Result() {

	}

	public Result(Integer code, String message, boolean success, T data) {
		this.code = code;
		this.message = message;
		this.success = success;
		this.data = data;
	}

	public static <T> Result<T> build(Integer code, String msg, T data, Boolean success) {
		return new Result<>(code, msg, success, data);
	}

	public static <T> Result<T> success(T data) {
		return build(SUCCCESS_CODE, SUCCCESS_MSG, data, Boolean.TRUE);
	}

	@SuppressWarnings("rawtypes")
	public static <T> Result<T> failed(Integer code, String msg) {
		return build(code, msg, null, Boolean.FALSE);
	}

	@SuppressWarnings("rawtypes")
	public static <T> Result<T> failed(ResultCodes errorCode) {
		return build(errorCode.getCode(), errorCode.getMessage(), null, Boolean.FALSE);
	}

}
