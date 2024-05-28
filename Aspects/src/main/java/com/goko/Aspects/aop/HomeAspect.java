package com.goko.Aspects.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Aspect
@Component
public class HomeAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.goko.Aspects.controllers.HomeController.math())")
    private void homeLoggerMathPointCut() {}

    @Pointcut("execution(* com.goko.Aspects.controllers.HomeController.*())")
    private void homeLoggerPointCut() {}

    @Pointcut("execution(String com.goko.Aspects.services.HomeService.getGreeting(..))")
    private void homeLoggerServicePointCut() {}

    @AfterThrowing("homeLoggerMathPointCut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("AfterThrowing: " + method + " with " + args);
    }

    @AfterReturning("homeLoggerPointCut()")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("AfterReturning: " + method + " with " + args);
    }

    @Before("homeLoggerServicePointCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before order(2) - method: " + method + " with arguments: " + args);
    }

    @After("homeLoggerServicePointCut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        /* String args = Arrays.toString(joinPoint.getArgs()); */
        logger.info("After order(2) - method: " + method);
    }

    @Around("homeLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // start stopwatch
        logger.info("Around: " + joinPoint.getSignature().getName());
        Object retVal = joinPoint.proceed();
        logger.info("Around: " + joinPoint.getSignature().getName());
        // stop stopwatch
        return retVal;

    }
}
