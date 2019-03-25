package com.ting.wong.code.springboot.action.service.exception;

import org.slf4j.Logger;

/**
 * 同{@link ApiException} ,但是日志会输出到error日志文件
 * 可以指定日志输出器 {@link #logger}
 * @author Ting Wong
 * @version 1.0
 * 2019/3/21
 * @see   ApiException
 **/
public class ApiLogErrorException extends ApiException{

    /**
     * 自定义日志输出器
     */
    private Logger logger;

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public ApiLogErrorException(String returnMessage) {
        super(returnMessage);
    }

    public ApiLogErrorException(String returnMessage,Logger logger) {
        super(returnMessage);
        this.logger = logger;
    }

    public ApiLogErrorException(String returnMessage, String logMessage) {
        super(returnMessage, logMessage);
    }

    public ApiLogErrorException(String returnMessage, String logMessage, Logger logger) {
        super(returnMessage, logMessage);
        this.logger = logger;
    }
}
