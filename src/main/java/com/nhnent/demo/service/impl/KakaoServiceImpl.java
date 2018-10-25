package com.nhnent.demo.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.nhnent.demo.service.NotificationService;

@Profile("dev")
@Service
public class KakaoServiceImpl implements NotificationService {

	@Override
	public boolean sendNotification(String phoneNumber, String message) {
		System.out.println("Trying to send Message via Kakao. phoneNumber:" + phoneNumber);
		System.out.println("Success to Send");
		return true;
	}

}
