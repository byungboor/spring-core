package com.nhndooray.edu.spring_core.config;

import com.nhndooray.edu.spring_core.service.NotificationService;
import com.nhndooray.edu.spring_core.service.impl.SmsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

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