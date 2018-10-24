package com.nhnent.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nhnent.demo.config.RootApplicationConfig;
import com.nhnent.demo.service.NotificationService;

public class JavaConfigServer {

	public static void main(String args[]) {

		ApplicationContext context = new AnnotationConfigApplicationContext(RootApplicationConfig.class);

		NotificationService notificationService = context.getBean(NotificationService.class);

		notificationService.sendNotification("01099499102", "Welcome to Dooray Service ");

		((AbstractApplicationContext) context).close();
	}

}
