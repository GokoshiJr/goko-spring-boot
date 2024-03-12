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

    @AfterThrowing("execution(* com.goko.Aspects.controllers.HomeController.math())")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("AfterThrowing: " + method + " with " + args);
    }

    @AfterReturning("execution(* com.goko.Aspects.controllers.HomeController.login())")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("AfterReturning: " + method + " with " + args);
    }

    @Before("execution(String com.goko.Aspects.services.HomeService.getGreeting(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before order(2) - method: " + method + " with arguments: " + args);
    }

    @After("execution(String com.goko.Aspects.services.HomeService.getGreeting(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After order(2) - method: " + method);
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
