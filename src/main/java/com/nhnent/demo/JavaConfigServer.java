package com.nhnent.demo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nhnent.demo.config.RootApplicationConfig;
import com.nhnent.demo.service.NotificationService;

public class JavaConfigServer {

	public static void main(String args[]) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootApplicationConfig.class);
        
        NotificationService notificationService = context.getBean(NotificationService.class);
        notificationService.sendNotification("01099499102", "Profiled Test");

        context.close();
	}

}
