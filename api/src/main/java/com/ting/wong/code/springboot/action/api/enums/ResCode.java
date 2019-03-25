package com.ting.wong.code.springboot.action.api.enums;

/**
 * 响应码
 *
 * @author Ting Wong
 * @version 1.0 2019/3/19
 **/
public enum ResCode {

    /**
     * 请求成功
     */
    SUCCESS(200, "Success."),

    /**
     * 参数错误
     */
    ILLEGAL_PARAMS(400, "Illegal parameter!"),

    /**
     * 用户没有登录
     */
    USER_NOT_LOGIN(403, "User not login."),

    /**
     * 处理失败
     */
    FAILED(500, "Processing failed, please contact developer!"),

    /**
     * 处理过程中抛出了异常
     */
    EXCEPTION(510, "System exception, please contact developer!"),

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(520, "System error, please contact developer!"),

    /**
     * 响应码1200-1250，Test相关错误码
     */
    TEST_ERROR(1200, "add test error!");


    /**
     * 响应码
     */
    public int code;
    /**
     * 响应message
     */
    public String msg;

    /**
     * @param code
     * @param msg
     */
    ResCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
