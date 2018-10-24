package com.nhnent.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nhnent.demo.service.NotificationService;
import com.nhnent.demo.service.impl.SmsServiceImpl;

@Configuration
public class RootApplicationConfig {

	@Bean
	public NotificationService notificationService() {
		return new SmsServiceImpl();
	}

}
