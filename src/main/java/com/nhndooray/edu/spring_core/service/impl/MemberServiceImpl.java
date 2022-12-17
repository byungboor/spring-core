package com.nhndooray.edu.spring_core.service.impl;

import com.nhndooray.edu.spring_core.domain.Member;
import com.nhndooray.edu.spring_core.service.MemberService;
import com.nhndooray.edu.spring_core.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class MemberServiceImpl implements MemberService {

    private final NotificationService notificationService;

    // TODO - 01
    // NotificationService 주입 대상 스프링 빈은 2개.
    // Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException:
    // --> @Primary 사용
    public MemberServiceImpl(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public boolean subscribe(Member member) {
        if (member == null)
            throw new IllegalArgumentException("Member is null");

        if (StringUtils.hasLength(member.getPhoneNumber()))
            notificationService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");

        return true;
    }

}
