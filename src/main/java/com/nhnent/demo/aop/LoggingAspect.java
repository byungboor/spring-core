package com.nhnent.demo.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.nhnent.demo.domain.Member;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("@annotation(com.nhnent.demo.stereotype.CustomLogger)")
    public void loggingPointCut() {
    }

    //    @Around(value = "@annotation(com.nhnent.benjamin.stereotype.CustomLogger)")
    @Around("loggingPointCut()")
    public Member around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Start Method! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
        Signature signature = pjp.getSignature();
        System.out.println("Started Method : " + signature.getName());

        Object[] args = pjp.getArgs();
        StringBuilder sb = new StringBuilder();
        for (Object arg : args) {
            sb.append(arg).append(",");
        }
        System.out.println("Started Method Arguments : " + sb.toString());

        Member member = (Member) pjp.proceed(args);

        System.out.println("After Method! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("return value : " + member.toString());

        return member;
    }
}
