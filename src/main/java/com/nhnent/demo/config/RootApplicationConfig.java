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

	// TODO 1. Bean 설정에 따라서 H2 디비와 MySQL 디비를 선택할 수 있는 구조입니다.
	// TODO 1. Beanの設定に応じてH2ディビとMySQLディビを選ぶことができる仕組みです。
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

	// TODO 2. JDBC 의 Connection 객체를 표현하는 클래스입니다.
	// TODO 2. JDBCのConnectionオブジェクトを表現するクラスです。
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

	// TODO 3. TransactionManager 선언.
	// TODO 3. TransactionManager宣言
	@Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);

		return transactionManager;
	}

	// TODO 4. MyBatis
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
