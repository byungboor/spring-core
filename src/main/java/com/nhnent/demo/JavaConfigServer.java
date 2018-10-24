package com.nhnent.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nhnent.demo.config.RootApplicationConfig;
import com.nhnent.demo.service.NotificationService;

public class JavaConfigServer {

	public static void main(String args[]) {

		ApplicationContext context = new AnnotationConfigApplicationContext(RootApplicationConfig.class);

		// TODO 4. KakaoServiceImpl Spring Bean 을 가져오기 위해서 적절한 Bean 이름과 Type 을 넣어주세요.
		// TODO 4. KakaoServiceImpl Spring Beanをもたらすために、適切なBeanの名前とTypeを入れてください。
		NotificationService kakaoService = context.getBean("??", Object.class);
		kakaoService.sendNotification("01099499102", "Welcome to Dooray Service ");
		
		// TODO 5. SmsServiceImpl Spring Bean 을 가져오기 위해서 적절한 Bean 이름과 Type 을 넣어주세요.
		// TODO 5. SmsServiceImpl Spring Beanをもたらすために、適切なBeanの名前とTypeを入れてください。
		NotificationService smsService = context.getBean("??", Object.class);
		smsService.sendNotification("01099499102", "Welcome to Dooray Service ");

		((AbstractApplicationContext) context).close();
	}

}
