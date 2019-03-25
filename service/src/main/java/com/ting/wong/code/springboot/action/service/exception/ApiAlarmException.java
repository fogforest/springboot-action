package com.ting.wong.code.springboot.action.service.exception;

import com.ting.wong.code.springboot.action.service.manager.alarm.AlarmBO;
import com.ting.wong.code.springboot.action.service.manager.alarm.AlarmHandler;

/**
 * 会触发告警的异常
 * 通过构造函数传入{@link AlarmBO},api捕获异常后打印日志信息,同时调用告警处理方法{@link AlarmHandler#handle()})}
 * @author Ting Wong
 * @version 1.0
 * 2019/3/21
 **/
public class ApiAlarmException extends ApiException {

    private AlarmHandler alarmHandler;

    public ApiAlarmException(AlarmBO alarmBO) {
        this.alarmHandler = alarmBO;
    }

    public ApiAlarmException(String returnMessage, AlarmBO alarmHandler) {
        super(returnMessage);
        this.alarmHandler = alarmHandler;
    }

    public ApiAlarmException(String returnMessage, String logMessage, AlarmBO alarmHandler) {
        super(returnMessage, logMessage);
        this.alarmHandler = alarmHandler;
    }

    public AlarmHandler getAlarmHandler() {
        return alarmHandler;
    }

    public void setAlarmHandler(AlarmBO alarmHandler) {
        this.alarmHandler = alarmHandler;
    }
}
