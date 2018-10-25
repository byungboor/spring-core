package com.nhnent.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.nhnent.demo.domain.Member;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* getAllMembers(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("Start Method! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
        Signature signature = joinPoint.getSignature();
        System.out.println("Started Method : " + signature.getName());

        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        for (Object arg : args) {
            sb.append(arg).append(",");
        }
        System.out.println("Started Method Arguments : " + sb.toString());
    }
    
    @AfterReturning(value = "execution(* getMember(..))", returning = "member")
    public void afterReturning(Member member) {
        System.out.println("After Method! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("return value : " + member.toString());
    }
}
