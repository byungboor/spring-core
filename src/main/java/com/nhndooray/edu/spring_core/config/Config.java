package com.nhndooray.edu.spring_core.config;

import com.nhndooray.edu.spring_core.service.NotificationService;
import com.nhndooray.edu.spring_core.service.impl.KakaoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public NotificationService notificationService() {
        return new KakaoServiceImpl();
//        return new SmsServiceImpl();
    }

}