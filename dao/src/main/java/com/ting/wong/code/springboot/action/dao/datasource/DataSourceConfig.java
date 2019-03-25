package com.ting.wong.code.springboot.action.dao.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据源配置
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/3/23
 **/
@Configuration
public class DataSourceConfig {

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    public DataSource slaveDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource masterDataSource() {
        return  DruidDataSourceBuilder.create().build();

    }

}
