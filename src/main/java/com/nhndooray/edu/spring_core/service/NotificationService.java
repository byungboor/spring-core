package com.nhndooray.edu.spring_core.service;

public interface NotificationService {
    boolean sendNotification(String phoneNumber, String message);

    String getType();

}
