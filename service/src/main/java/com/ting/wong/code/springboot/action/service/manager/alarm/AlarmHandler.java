package com.ting.wong.code.springboot.action.service.manager.alarm;

/**
 * 处理告警接口
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/3/22
 **/
public interface AlarmHandler {

    /**
     * 处理告警，根据告警信息触发告警
     * @param
     * @return
     */
    boolean handle();
}
