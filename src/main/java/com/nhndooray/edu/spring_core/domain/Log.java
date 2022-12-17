package com.nhndooray.edu.spring_core.domain;

public class Log {
    private String notiType;
    private String phoneNumber;


    public Log() {
        // nothing
    }

    public Log(String notiType, String phoneNumber) {
        this.notiType = notiType;
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "notiType=" + notiType + ", phoneNumber=" + phoneNumber;
    }

    public String getNotiType() {
        return notiType;
    }

    public void setNotiType(String notiType) {
        this.notiType = notiType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
