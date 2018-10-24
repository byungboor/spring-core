package com.nhnent.demo;

import com.nhnent.demo.service.NotificationService;
import com.nhnent.demo.service.impl.KakaoServiceImpl;

public class ClassicServer {

	public static void main(String args[]) {
		NotificationService notificationService = new KakaoServiceImpl();
		notificationService.sendNotification("01099499102", "Welcome to Dooray Service ");
	}

}
