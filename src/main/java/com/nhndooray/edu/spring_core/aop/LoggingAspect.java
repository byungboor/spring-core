package com.nhndooray.edu.spring_core.aop;

import com.nhndooray.edu.spring_core.domain.Member;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
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

    @AfterReturning(
            value = "execution(* com.nhndooray.edu.spring_core.repository.NotiLogDao.insertLog(..))",
            returning = "logId"
    )
    public void logAfterInsertLog(JoinPoint joinPoint, int logId) {

        Member member = retrieveArgument(joinPoint, Member.class, "member");
        LOGGER.warn("member={}, inserted log_id={}", member, logId);
    }

    public static <T> T retrieveArgument(JoinPoint joinPoint, Class<T> argType, String argName) {
        String[] keys = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        Object[] vals = joinPoint.getArgs();

        if (isEmpty(keys) || isEmpty(vals) || keys.length != vals.length) {
            return null;
        }

        for (int i = 0; i < vals.length; i++) {
            if (argName.equals(keys[i])) {
                return argType.cast(vals[i]);
            }
        }

        return null;
    }

    private static boolean isEmpty(Object[] objects) {
        if (objects == null)
            return true;
        if (objects.length == 0)
            return true;

        return false;
    }

}