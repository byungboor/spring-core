package com.nhndooray.edu.spring_core.config;

import com.nhndooray.edu.spring_core.service.MemberService;
import com.nhndooray.edu.spring_core.service.NotificationService;
import com.nhndooray.edu.spring_core.service.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    @Autowired
    private Config config;

    @Autowired
    private NotificationService smsService;

    @Bean("memberService")
    public MemberService memberService() {
        return new MemberServiceImpl(smsService, config.kakaoService());
    }
}
