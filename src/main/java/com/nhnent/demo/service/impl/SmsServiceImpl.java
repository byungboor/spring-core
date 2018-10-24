package com.nhnent.demo.service.impl;

import com.nhnent.demo.service.NotificationService;

public class SmsServiceImpl implements NotificationService {

	public boolean sendNotification(String phoneNumber, String message) {
		System.out.println("Trying to send Message via Simple Text Service Center. phoneNumber:" + phoneNumber);
		System.out.println("Success to Send");
		return true;
	}

}
