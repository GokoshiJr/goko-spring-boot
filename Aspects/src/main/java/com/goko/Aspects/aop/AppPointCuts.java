package com.goko.Aspects.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppPointCuts {
    @Pointcut("execution(* com.goko.Aspects.controllers.HomeController.math())")
    public void homeLoggerMathPointCut() {}

    @Pointcut("execution(* com.goko.Aspects.controllers.HomeController.*())")
    public void homeLoggerPointCut() {}

    @Pointcut("execution(String com.goko.Aspects.services.HomeService.getGreeting(..))")
    public void homeLoggerServicePointCut() {}
}
