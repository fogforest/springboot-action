package com.ting.wong.code.springboot.action.service.manager.alarm;


import org.apache.commons.lang3.builder.Builder;

/**
 * 告警数据结构
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/3/22
 **/
public class AlarmBO implements AlarmHandler{

    @Override
    public boolean handle() {
        //TODO 处理告警逻辑
        return false;
    }

    public static class AlarmBuilder implements Builder<AlarmBO> {
        @Override
        public AlarmBO build() {
            AlarmBO alarmBO = new AlarmBO();
            return alarmBO;
        }
    }

}
