package com.nhndooray.edu.spring_core.service.impl;

import com.nhndooray.edu.spring_core.service.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class KakaoServiceImpl implements NotificationService {
    @Override
    public boolean sendNotification(String phoneNumber, String message) {
        System.out.println("Trying to send message via Kakao. phoneNumber: " + phoneNumber);
        System.out.println("Success to send message");

        return true;
    }

    public String getType() {
        return "Kakao";
    }
}
