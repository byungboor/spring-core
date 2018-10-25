package com.nhnent.demo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nhnent.demo.dao.MemberDao;
import com.nhnent.demo.domain.Member;
import com.nhnent.demo.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public Member getMember() {
		Member member = memberDao.exist("dongmyo@nhnent.com", "12345");
		if (member == null) {
			member = new Member();
			member.setEmail("dongmyo@nhnent.com");
			member.setPassword("12345");
			member.setName("dongmyo");
			member.setCreatedDate(new Date());
			member.setModifiedDate(new Date());
		}

		return member;
	}
}
