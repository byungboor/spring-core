package com.nhnent.demo.service.impl;

import org.springframework.stereotype.Service;

import com.nhnent.demo.service.NotificationService;

@Service(value = "kakaoService")
public class KakaoServiceImpl implements NotificationService {

	@Override
	public boolean sendNotification(String phoneNumber, String message) {
		System.out.println("Trying to send Message via Kakao. phoneNumber:" + phoneNumber);
		System.out.println("Success to Send");
		return true;
	}

}
