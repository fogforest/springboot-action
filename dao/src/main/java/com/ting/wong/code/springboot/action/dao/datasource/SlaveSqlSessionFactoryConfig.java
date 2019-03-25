package com.ting.wong.code.springboot.action.dao.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 应用平台数据源配置
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/3/23
 **/
@Configuration
@MapperScan(basePackages = SlaveSqlSessionFactoryConfig.PACKAGE, sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class SlaveSqlSessionFactoryConfig {

    public static final String PACKAGE = "com.ting.wong.code.springboot.action.dao.mapper.slave";
    public static final String MAPPER_LOCATION = "classpath:mapper/slave/*.xml";

    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(slaveDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}
