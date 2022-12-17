package com.nhndooray.edu.spring_core.config;

import com.nhndooray.edu.spring_core.service.NotificationService;
import com.nhndooray.edu.spring_core.service.impl.KakaoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// TODO : #2 데이터베이스 설정 추가.
@Import(DatabaseConfig.class)
@ComponentScan(basePackages = "com.nhndooray.edu.spring_core")
public class Config {

}