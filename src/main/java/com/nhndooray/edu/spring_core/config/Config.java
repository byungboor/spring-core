package com.nhndooray.edu.spring_core.config;

import com.nhndooray.edu.spring_core.service.NotificationService;
import com.nhndooray.edu.spring_core.service.impl.SmsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

// TODO : #3 JoinPoint에서 method parameter name을 가져오기 위해서.
// TODO : #3 `@EnableAspectJAutoProxy(proxyTargetClass = true)` for retrieving the method parameter name from JoinPoint.
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
@Import(DatabaseConfig.class)
@ComponentScan(basePackages = "com.nhndooray.edu.spring_core")
public class Config {


    @Bean
    @Profile("default")
    public NotificationService notificationService() {
        return new SmsServiceImpl();
    }

}