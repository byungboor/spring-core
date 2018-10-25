package com.nhnent.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nhnent.demo.config.RootApplicationConfig;
import com.nhnent.demo.domain.Member;
import com.nhnent.demo.service.MemberService;

public class JavaConfigServer {

	public static void main(String args[]) throws Exception {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				RootApplicationConfig.class);

		MemberService memberService = context.getBean(MemberService.class);

		Member member = memberService.getMember();
		System.out.println(member.getEmail());

		context.close();
	}

}
