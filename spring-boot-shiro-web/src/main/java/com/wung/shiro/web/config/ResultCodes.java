package com.wung.shiro.web.config;


/**
 *
 * @ClassName: ResultCode
 * @Description: 响应代码，前面6个0，后面两位为流水号
 * @author wungmc
 * @date 2017/6/20
 *
 */
public enum ResultCodes {
	
	/**
	 * 通用成功
	 */
    SUCCESS(0, "成功"),

    /**
     * 通用错误码 2000X
     */
    SYS_EXCEPTION(-20001, "系统异常"),
    USER_UNAUTHORIZED(20002, "用户未授权"),
    OPERATION_REPEAT(20003, "重复操作"),
    OPERATION_FAIL(20004, "非法操作"),
	
    /**
     * 登录相关 2004X
     */
    LOGIN_FAIL(20040, "用户或密码错误"),
    LOGIN_EXCEPTION(20041, "登录异常"),
    LOGIN_NO_LOGIN(20042, "用户未登录或登录超时"),

    ;


    private Integer code;
    private String message;

    ResultCodes(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
