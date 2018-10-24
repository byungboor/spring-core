package com.nhnent.demo;

import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

import com.nhnent.demo.service.NotificationService;
import com.nhnent.demo.service.impl.SmsServiceImpl;

public class BeanDefinitionServer {

	public static void main(String[] args) {
		StaticApplicationContext context = new StaticApplicationContext();
		context.registerBeanDefinition("notificationService", new RootBeanDefinition(SmsServiceImpl.class));
		
		NotificationService notificationService = NotificationService.class.cast(context.getBean("notificationService"));
		notificationService.sendNotification("01099499102", "Welcome to Dooray Service ");
		
		context.close();
	}
	
}
