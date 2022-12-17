package com.nhndooray.edu.spring_core.service.impl;

import com.nhndooray.edu.spring_core.domain.Member;
import com.nhndooray.edu.spring_core.service.MemberService;
import com.nhndooray.edu.spring_core.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class MemberServiceImpl implements MemberService {

    private NotificationService smsService;
    private NotificationService kakaoService;

    // TODO-01
    @Autowired
    public void setSmsService(NotificationService smsService) {
        this.smsService = smsService;
    }

    // TODO-02
    @Autowired
    @Qualifier("kakaoService")
    public void setKakaoService(NotificationService kakaoService) {
        this.kakaoService = kakaoService;
    }

    @Override
    public boolean subscribe(Member member) {
        if (member == null)
            throw new IllegalArgumentException("Member is null");

        if (StringUtils.hasLength(member.getPhoneNumber()))
            smsService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");

        if (StringUtils.hasLength(member.getPhoneNumber()))
            kakaoService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");


        return true;
    }

}
