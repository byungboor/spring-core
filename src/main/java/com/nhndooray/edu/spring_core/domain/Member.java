package com.nhndooray.edu.spring_core.domain;

public class Member {
    private final String name;
    private final String phoneNumber;


    public Member(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

}
