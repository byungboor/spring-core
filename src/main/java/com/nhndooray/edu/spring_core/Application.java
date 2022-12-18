package com.nhndooray.edu.spring_core;

import com.nhndooray.edu.spring_core.config.Config;
import com.nhndooray.edu.spring_core.domain.Member;
import com.nhndooray.edu.spring_core.service.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class)) {
            MemberService memberService = applicationContext.getBean(MemberService.class);
            memberService.subscribe(new Member("김병부", "01099499102"));

            Member member1 = memberService.getOrCreateMember(new Member("nhn", "01000000000"));
            System.out.println(member1);

            Member member2 = memberService.getOrCreateMember(new Member("global", "01099999999"));
            System.out.println(member2);

            memberService.exchangeMembers(member1, member2);
        }
    }

}
