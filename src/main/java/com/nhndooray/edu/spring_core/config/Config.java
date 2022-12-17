package com.nhndooray.edu.spring_core.config;

import com.nhndooray.edu.spring_core.service.NotificationService;
import com.nhndooray.edu.spring_core.service.ServiceMarker;
import com.nhndooray.edu.spring_core.service.impl.KakaoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ServiceMarker.class)
public class Config {

    @Bean
    public NotificationService kakaoService() {
        return new KakaoServiceImpl();
    }

}