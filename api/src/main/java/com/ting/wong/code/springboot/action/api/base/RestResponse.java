package com.ting.wong.code.springboot.action.api.base;

import com.ting.wong.code.springboot.action.api.enums.ResCode;

/**
 * 统一响应类
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/3/19
 **/
public class RestResponse<T> {

    private int code;
    private String msg;
    private T data;

    /**
     * 成功
     */
    public static final RestResponse SUCCESS = new RestResponse(ResCode.SUCCESS);
    /**
     * 请求处理失败
     */
    public static final RestResponse FAILED = new RestResponse(ResCode.FAILED);
    /**
     * 参数不合法
     */
    public static final RestResponse ILLEGAL_PARAMS = new RestResponse(ResCode.ILLEGAL_PARAMS);

    public RestResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RestResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResponse(ResCode resCode) {
        this(resCode.code, resCode.msg);
    }

    public RestResponse(ResCode resCode, T data) {
        this(resCode.code, resCode.msg, data);
    }

    public RestResponse(ResCode resCode, String msg) {
        this(resCode.code, resCode.msg + msg);
    }

    public RestResponse(ResCode resCode, String msg, T data) {
        this(resCode.code, resCode.msg + msg, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
