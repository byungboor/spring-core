package com.nhndooray.edu.spring_core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// TODO : #1 `com.nhnent.edu.spring_core.repository.NotiLogDao.insertLog` 메쏘드 수행시간 로깅을 위한 aspect.
// TODO : #1 aspect for logging the execution time of `com.nhnent.edu.spring_core.repository.NotiLogDao.insertLog` method. 
@Component
@Aspect
// TODO : #2 aspect간 우선순위 지정.
// TODO : #2 set order among aspects.
@Order(1)
public class MeasuringAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(MeasuringAspect.class);


    @Around("execution(* com.nhndooray.edu.spring_core.repository.NotiLogDao.insertLog(..))")
    public Object logInsertLogPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result;
        try {
            result = joinPoint.proceed();
        } finally {
            stopWatch.stop();
            LOGGER.warn("NotiLogDao.insertLog execution: {} ms", stopWatch.getLastTaskTimeMillis());
        }

        /*
         * TODO : #3 만약 ...
         * joinPoint.process()를 하지 않으면?
         * 다른 값을 return 하면?
         */
        /*
         * TODO : #3 what if ...
         * joinPoint.proceed() is removed ?
         * wrong value is returned
         */
        return result;
    }

}
