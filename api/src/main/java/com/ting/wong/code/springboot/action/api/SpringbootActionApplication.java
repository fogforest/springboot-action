package com.ting.wong.code.springboot.action.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 算法平台入口类
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/3/19
 **/
@SpringBootApplication(scanBasePackages = {"com.ting.wong.code.springboot.action.service", "com.ting.wong.code.springboot.action.api","com.ting.wong.code.springboot.action.dao.datasource"})
public class SpringbootActionApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringbootActionApplication.class, args);
    }

}
