package com.nhnent.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nhnent.demo.config.RootApplicationConfig;
import com.nhnent.demo.domain.Member;
import com.nhnent.demo.service.MemberService;

public class JavaConfigServer {

	public static void main(String args[]) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootApplicationConfig.class);
        
        
        MemberService memberService = context.getBean(MemberService.class);

        Member member1 = memberService.createMember("dongmyo@nhnent.com", "123123", "신동민");
        Member member2 = memberService.createMember("byungboo.kim@nhnent.com", "234234", "김병부");

        System.out.println("BEFORE ----------------------------------------");
        System.out.println(member1);
        System.out.println(member2);
        System.out.println("-----------------------------------------------");

        try {
            memberService.exchangeMemberName(member1, member2);
        } catch (Exception e) {

        }

        List<Member> members = memberService.getAllMembers();
        System.out.println("AFTER -----------------------------------------");
        System.out.println(members.size());
        members.stream().forEach(System.out::println);
        System.out.println("-----------------------------------------------");
        
        memberService.getMember("dongmyo@nhnent.com", "123123");

        context.close();
	}

}
