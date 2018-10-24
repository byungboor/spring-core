package com.nhnent.demo.service.impl;

import org.springframework.stereotype.Service;

import com.nhnent.demo.service.NotificationService;

// TODO 2. 아래 클래스를 Bean으로 만들때, SmsServiceImpl과 구분하기 위해서 Bean 의 이름을 지정해야 합니다.
// TODO2.下のクラスをBeanとして作成するときに、SmsServiceImplと区別するためにBeanの名前を指定する必要があります。
@Service(value = "???")
public class KakaoServiceImpl implements NotificationService {

	@Override
	public boolean sendNotification(String phoneNumber, String message) {
		System.out.println("Trying to send Message via Kakao. phoneNumber:" + phoneNumber);
		System.out.println("Success to Send");
		return true;
	}

}
