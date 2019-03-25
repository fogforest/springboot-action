package com.ting.wong.code.springboot.action.dao.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 算法平台数据源配置
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/3/23
 **/
@Configuration
@MapperScan(basePackages = MasterSqlSessionFactoryConfig.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterSqlSessionFactoryConfig {

    public static final String PACKAGE = "com.ting.wong.code.springboot.action.dao.mapper.master";
    public static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
