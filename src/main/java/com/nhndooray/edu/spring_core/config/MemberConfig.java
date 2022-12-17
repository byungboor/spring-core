package com.nhndooray.edu.spring_core.config;

import com.nhndooray.edu.spring_core.config.Config;
import com.nhndooray.edu.spring_core.service.MemberService;
import com.nhndooray.edu.spring_core.service.NotificationService;
import com.nhndooray.edu.spring_core.service.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO-01
@Configuration
public class MemberConfig {

    // TODO-02
    @Autowired
    private Config config;

    // TODO-03
    @Autowired
    private NotificationService smsService;

    // TODO-04
    @Bean("memberService")
    public MemberService memberService() {
        return new MemberServiceImpl(smsService, config.kakaoService());
    }
}
