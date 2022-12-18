package com.nhndooray.edu.spring_core.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// TODO : #6 Logging Aspect.
@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* getOrCreateMember(..))")
    public void log() {
        LOGGER.warn("getOrCreateMember method is called");
    }

}