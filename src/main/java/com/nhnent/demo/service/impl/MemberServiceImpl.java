package com.nhnent.demo.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nhnent.demo.domain.Member;
import com.nhnent.demo.service.MemberService;
import com.nhnent.demo.service.NotificationService;

@Service
public class MemberServiceImpl implements MemberService {

	private NotificationService smsService;
    private NotificationService kakaoService;

    @Autowired
    public MemberServiceImpl(NotificationService smsService,
                             @Qualifier("kakaoService") NotificationService kakaoService) {
        this.smsService = smsService;
        this.kakaoService = kakaoService;
    }
    
    // TODO - PostConstruct
    @PostConstruct
    public void init() {
        System.out.println("--------------------------- init    --------------------------");
    }

    // TODO - PreDestory
    @PreDestroy
    public void destroy() {
        System.out.println("--------------------------- destroy --------------------------");
    }

	@Override
	public boolean subscribe(Member member) {

		if (member == null)
			throw new IllegalArgumentException("Member is null");

		/**
		 * TODO - persist Member object.
		 */

		if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty())
			smsService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");

		if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty())
			kakaoService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");

		return true;
	}
}
