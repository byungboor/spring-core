package com.nhndooray.edu.spring_core.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* getOrCreateMember(..))")
    public void log() {
        LOGGER.warn("getOrCreateMember method is called");
    }

    // TODO : #2 실습 - `com.nhndooray.edu.spring_core.repository.NotiLogDao.insertLog` 메쏘드가 성공적으로 리턴된 후 반환되는 logId 값을 로그로 남겨주세요.
    //    @???(value = "???",
    //            returning = "logId")
    public void logAfterInsertLog(int logId) {
        LOGGER.debug("inserted log_id={}", logId);
    }


}