package com.nhnent.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nhnent.demo.domain.Member;
import com.nhnent.demo.service.MemberService;
import com.nhnent.demo.service.NotificationService;

@Service
public class MemberServiceImpl implements MemberService {
	
	// TODO - 1. autowired annotation
	@Autowired
	private NotificationService smsService;

	// TODO - 2. Qualifier annotation
	@Autowired
	@Qualifier("kakaoService")
	private NotificationService kakaoService;

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
