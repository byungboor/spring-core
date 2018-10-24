package com.nhnent.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nhnent.demo.service.NotificationService;

public class JavaConfigServer {

	public static void main(String args[]) {

		ApplicationContext context = null;

		// TODO 1. 적절한 ApplicationContext 구현체 클래스를 이용해서 context를 생성하세요.
		// TODO 1. 適切なApplicationContextの実装クラスを利用して、contextを生成します。
		// ApplicationContext context = new ???ApplicationContext(??);

		NotificationService notificationService = context.getBean(NotificationService.class);

		notificationService.sendNotification("01099499102", "Welcome to Dooray Service ");

		((AbstractApplicationContext) context).close();
	}

}
