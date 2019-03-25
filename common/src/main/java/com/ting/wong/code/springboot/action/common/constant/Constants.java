package com.ting.wong.code.springboot.action.common.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Ting Wong
 * @version 1.0
 * @date 2019/3/19
 * @description 常量
 * 不同模块的常量需要放到不同的类里面，这里是公共常量
 **/
public interface Constants {

    /**
     * 默认时间格式
     **/
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 默认时区
     **/
    public static final String DATE_TIMEZONE = "GMT+8";

    /**
     * UTF-8字符集
     **/
    public static final String CHARSET_UTF8 = "UTF-8";

    /**
     * 字符串常量
     */
    public static final String EMPTY = StringUtils.EMPTY;

    public static final String SINGLE_QUOTE = "'";

    public static final String DOUBLE_QUOTE = "\"";

    public static final String SPACE = StringUtils.SPACE;

    public static final String WORD_DELIM = ", ";

    public static final String BACKSLASH = "/";

}
