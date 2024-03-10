package com.goko.Aspects.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class HomeAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(String com.goko.Aspects.services.HomeService.getGreeting(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before: " + method + " with " + args);
    }

    @After("execution(String com.goko.Aspects.services.HomeService.getGreeting(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After: " + method + " method ");
    }

    @Around("execution(* com.goko.Aspects.controllers.HomeController.home())")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // start stopwatch
        logger.info("Around: " + joinPoint.getSignature().getName());
        Object retVal = joinPoint.proceed();
        logger.info("Around: " + joinPoint.getSignature().getName());
        // stop stopwatch
        return retVal;

    }
}
