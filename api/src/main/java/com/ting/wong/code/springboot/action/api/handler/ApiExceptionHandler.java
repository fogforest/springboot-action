package com.ting.wong.code.springboot.action.api.handler;

import com.ting.wong.code.springboot.action.api.base.RestResponse;
import com.ting.wong.code.springboot.action.api.enums.ResCode;
import com.ting.wong.code.springboot.action.service.exception.ApiAlarmException;
import com.ting.wong.code.springboot.action.service.exception.ApiException;
import com.ting.wong.code.springboot.action.service.exception.ApiLogErrorException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理类
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/3/21
 **/
@ControllerAdvice
public class ApiExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public RestResponse<?> handleException(Exception ex) {
        LOGGER.warn(ex.getMessage(), ex);
        return new RestResponse<>(ResCode.EXCEPTION);
    }

    @ResponseBody
    @ExceptionHandler(value = {ApiException.class})
    public RestResponse<?> handleApiException(ApiException ex) {
        LOGGER.warn(ex.getMessage(), ex);
        if (StringUtils.isNotBlank(ex.getReturnMessage())) {
            return new RestResponse<>(ResCode.EXCEPTION, ex.getReturnMessage());
        }
        return new RestResponse<>(ResCode.EXCEPTION);
    }

    @ResponseBody
    @ExceptionHandler(value = {ApiLogErrorException.class})
    public RestResponse<?> handleApiLogErrorException(ApiLogErrorException ex) {
        if (ex.getLogger() == null) {
            LOGGER.error(ex.getMessage(), ex);
        } else {
            ex.getLogger().error(ex.getMessage(), ex);
        }
        if (StringUtils.isNotBlank(ex.getReturnMessage())) {
            return new RestResponse<>(ResCode.EXCEPTION, ex.getReturnMessage());
        }
        return new RestResponse<>(ResCode.EXCEPTION);
    }

    @ResponseBody
    @ExceptionHandler(value = {ApiAlarmException.class})
    public RestResponse<?> handleApiAlarmException(ApiAlarmException ex) {
        LOGGER.error(ex.getMessage(), ex);
        ex.getAlarmHandler().handle();
        if (StringUtils.isNotBlank(ex.getReturnMessage())) {
            return new RestResponse<>(ResCode.EXCEPTION, ex.getReturnMessage());
        }
        return new RestResponse<>(ResCode.EXCEPTION);
    }

}
