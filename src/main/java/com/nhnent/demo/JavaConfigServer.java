package com.nhnent.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nhnent.demo.config.RootApplicationConfig;
import com.nhnent.demo.domain.Member;
import com.nhnent.demo.service.MemberService;

public class JavaConfigServer {

	public static void main(String args[]) throws Exception {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				RootApplicationConfig.class);

		Member member = new Member("김병부", "01099499102");
		MemberService memberService = context.getBean(MemberService.class);
		memberService.subscribe(member);

		Thread.sleep(1000L);
		context.close();
	}

}
