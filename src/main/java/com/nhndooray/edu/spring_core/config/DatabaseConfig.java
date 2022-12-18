package com.nhndooray.edu.spring_core.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class DatabaseConfig {

    @Value("#{h2Properties['datasource.driver-class-name']}")
    private String driverClassName;

    @Value("#{h2Properties['datasource.url']}")
    private String url;

    @Value("#{h2Properties['datasource.username'] ?: 'sa'}")
    private String username;

    @Value("#{h2Properties['datasource.password:'] ?: ''}")
    private String password;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        dataSource.setInitialSize(10);
        dataSource.setMaxTotal(10);
        dataSource.setMaxIdle(10);
        dataSource.setMinIdle(10);

        dataSource.setMaxWaitMillis(1000);

        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);

        dataSource.setTimeBetweenEvictionRunsMillis(30000);

        dataSource.setNumTestsPerEvictionRun(5);
        dataSource.setMinEvictableIdleTimeMillis(-1);
        dataSource.setValidationQuery("SELECT 0");
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxOpenPreparedStatements(50);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }


    @Bean
    public Properties mysqlProperties() throws IOException {
        return PropertiesLoaderUtils.loadAllProperties("datasource/mysql.properties");
    }

    // TODO 01
    @Bean
    public Properties h2Properties() throws IOException {
        return PropertiesLoaderUtils.loadAllProperties("datasource/h2.properties");
    }

}
