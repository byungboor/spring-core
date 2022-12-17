package com.nhndooray.edu.spring_core;

import com.nhndooray.edu.spring_core.config.Config;
import com.nhndooray.edu.spring_core.domain.Member;
import com.nhndooray.edu.spring_core.service.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    // TODO - 00
    // 지문 : MemberService 스프링 빈을 가져와서 subscribe 메서드를 호출합니다.
    //
    // - 다음과 같이 Console 에 출력하는 KakaoServiceImpl 클래스를 com.nhndooray.edu.spring_core.service.impl에 만드세요.
    // - KakaoServiceImpl는 com.nhndooray.edu.spring_core.config.Config.java 클래스에 @Bean 을 사용하여 스프링 빈으로 정의하세요
    // --------------------------------------------------------------------------
    //    Trying to send message via Kakao. phoneNumber: 01099499102
    //    Success to send message
    // --------------------------------------------------------------------------
    //
    // - 다음과 같이 Console 에 출력하는 SmsServiceImpl 클래스를 com.nhndooray.edu.spring_core.service.impl에 만드세요 & 스프링 빈으로 정의하세요
    // - SmsServiceImpl는 @Service 을 사용하여 스프링 빈으로 정의하세요. & 컴포넌트 스켄을 사용해서 스켄하세요
    // --------------------------------------------------------------------------
    //    Trying to send message via SMS center. phoneNumber: 01099499102
    //    Success to send message
    // --------------------------------------------------------------------------
    //
    // - SmsService, KakaoService 스프링 빈을 생성자 주입 방식으로 주입받는 MemberServiceImpl 을 스프링 빈으로 주입받고
    // boolean subscribe(Member member) 메서드를 구현합니다. subscribe 메서드 내부에는 SmsService, KakaoService 스프링 빈의 메서드를 각각 호출합니다.
    //
    // - 다음 main 메서드를 실행해봅시다.

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class)) {
            MemberService memberService = applicationContext.getBean(MemberService.class);
            memberService.subscribe(new Member("김병부", "01099499102"));
        }
    }

}
