package com.nhndooray.edu.spring_core.service.impl;

import com.nhndooray.edu.spring_core.service.NotificationService;

public class KakaoServiceImpl implements NotificationService {
    @Override
    public boolean sendNotification(String phoneNumber, String message) {
        System.out.println("Trying to send message via Kakao. phoneNumber: " + phoneNumber);
        System.out.println("Success to send message");

        return true;
    }

}
