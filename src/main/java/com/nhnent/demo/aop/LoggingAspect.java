package com.nhnent.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* getAllMembers(..))")
    public void before() {
        System.out.println("Start Method! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
    }
}
