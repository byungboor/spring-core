package com.nhnent.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nhnent.demo.service.NotificationService;

public class Server {

	private static final String CONTEXT_PATH = "applicationContext.xml";

	// TODO 2.
    public static void main(String args[]) {
    	
    	// TODO 3. how to change implemented class using DI? Check point is CONTEXT_PATH
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_PATH);
        NotificationService notificationService = context.getBean(NotificationService.class);

        notificationService.sendNotification("01099499102", "Welcome to Dooray Service ");
        context.close();
    }
	
}
