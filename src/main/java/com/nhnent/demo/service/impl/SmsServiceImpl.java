package com.nhnent.demo.service.impl;

import org.springframework.stereotype.Service;

import com.nhnent.demo.service.NotificationService;

@Service("smsService")
public class SmsServiceImpl implements NotificationService {

	public boolean sendNotification(String phoneNumber, String message) {
		System.out.println("Trying to send Message via Simple Text Service Center. phoneNumber:" + phoneNumber);
		System.out.println("Success to Send");
		return true;
	}

}
