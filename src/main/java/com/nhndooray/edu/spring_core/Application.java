package com.nhndooray.edu.spring_core;

import com.nhndooray.edu.spring_core.config.Config;
import com.nhndooray.edu.spring_core.domain.Member;
import com.nhndooray.edu.spring_core.service.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    // TODO-04 실행
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class)) {
            MemberService memberService = applicationContext.getBean(MemberService.class);
            memberService.subscribe(new Member("김병부", "01099499102"));
        }
    }

}
