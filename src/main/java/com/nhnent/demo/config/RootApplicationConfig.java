package com.nhnent.demo.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan(basePackages = {
		"com.nhnent.demo.dao.**", 
		"com.nhnent.demo.service.**" 
})
public class RootApplicationConfig {

	private static final Map<String, String> JDBC_PROPERTY_LOCATION_MAP = new HashMap<>();

	static {
		JDBC_PROPERTY_LOCATION_MAP.put("h2", "classpath:properties/h2.jdbc.properties");
		JDBC_PROPERTY_LOCATION_MAP.put("mysql", "classpath:properties/mysql.jdbc.properties");
	}

	@Bean
	public String dbms() {
		return "h2";
	}

	@Bean
	public Resource jdbcPropertyLocation(ApplicationContext applicationContext, String dbms) {
		return applicationContext.getResource(JDBC_PROPERTY_LOCATION_MAP.get(dbms));
	}

	@Bean
	public PropertyPlaceholderConfigurer placeholderConfigurer(Resource jdbcProperties) {
		PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
		placeholderConfigurer.setLocation(jdbcProperties);
		return placeholderConfigurer;
	}

	@Bean
	public DataSource dataSource(@Value("${jdbc.driverClassName}") String driverClassName,
			@Value("${jdbc.url}") String url, @Value("${jdbc.username}") String username,
			@Value("${jdbc.password}") String password) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		return dataSource;
	}

	@Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);

		return transactionManager;
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean sqlSessionFactory(org.springframework.context.ApplicationContext applicationContext,
			DataSource dataSource) throws IOException {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:/mapper/mybatis-config.xml"));
		sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:/mapper/*Mapper.xml"));

		return sqlSessionFactory;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
