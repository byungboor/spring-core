package com.nhnent.demo.config;

import com.nhnent.demo.service.NotificationService;
import com.nhnent.demo.service.impl.SmsServiceImpl;

// TODO 2. JavaConfig로 ApplicationContext를 설정할때, 설정파일에 필요한 Annotation 을 입력해주세요.
// TODO 2. JavaConfigにApplicationContextを設定するときは、設定ファイルに必要なAnnotationを入力してください。
public class RootApplicationConfig {

	// TODO 3. Spring Bean 을 선언하기 위한 Annotation 을 입력해주세요.
	// TODO 3. Spring Beanを宣言するためのAnnotationを入力してください。
	public NotificationService notificationService() {
		return new SmsServiceImpl();
	}

}
