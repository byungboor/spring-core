package com.nhnent.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nhnent.demo.service.NotificationService;

public class Server {

	private static final String CONTEXT_PATH = "applicationContext.xml";

    public static void main(String args[]) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_PATH);
        NotificationService notificationService = context.getBean(NotificationService.class);

        notificationService.sendNotification("01099499102", "Welcome to Dooray Service ");
        context.close();
    }
	
}
