package com.ting.wong.code.springboot.action.service.exception;

/**
 * ApiException
 * API业务异常
 * 业务层把异常往上抛，API层捕捉后返回统一友好响应给前端
 * 返回 {@link #returnMessage} 给前端做为提示信息
 * 可以通过构造函数{@link #ApiException(String, String)}指定打印的logMessage，不指定则打印{@link #returnMessage}
 * 日志输出到warn日志
 * @author Ting Wong
 * @version 1.0
 * 2019/3/21
 * @see RuntimeException
 **/
public class ApiException extends RuntimeException{

    /**
     * 需要返回给前端的提示信息
     */
    private String returnMessage;

    public ApiException() {
    }

    /**
     * returnMessage 前端提示
     * @param returnMessage
     */
    public ApiException(String returnMessage) {
        super(returnMessage);
        this.returnMessage = returnMessage;
    }

    /**
     *
     * @param returnMessage 前端提示
     * @param logMessage 日志记录信息
     */
    public ApiException(String returnMessage,String logMessage) {
        super(logMessage);
        this.returnMessage = returnMessage;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}
