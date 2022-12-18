package com.nhndooray.edu.spring_core.domain;

public class Member {
    private String name;
    private String phoneNumber;

    public Member() {
        // nothing
    }

    public Member(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Member{" +
               "name='" + name + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               '}';
    }
}
