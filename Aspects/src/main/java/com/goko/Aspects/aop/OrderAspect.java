package com.goko.Aspects.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Component
@Aspect
public class OrderAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(String com.goko.Aspects.services.HomeService.getGreeting(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before order(1) - method: " + method + " with arguments: " + args);
    }


}
