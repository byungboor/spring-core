package com.nhndooray.edu.spring_core.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
// TODO : #2 instead of @PropertySource.
//@PropertySource("classpath:datasource.properties")
public class DatabaseConfig {

    // TODO : #1 use @Value("${...}")
    @Value("${datasource.driver-class-name}")
    private String driverClassName;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username:sa}")
    private String username;

    @Value("${datasource.password:}")
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

    // TODO : #3 use PropertySourcesPlaceholderConfigurer.
    // does it work?
    @Bean
    public /*static*/ PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        placeholderConfigurer.setLocation(new ClassPathResource("datasource.properties"));
        return placeholderConfigurer;
    }

}
