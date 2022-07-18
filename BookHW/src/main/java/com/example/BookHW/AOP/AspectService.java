package com.example.BookHW.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AspectService {
    @Before("inControllerLayer()")
    public void beforeControllerLayer(JoinPoint joinPoint){
        System.out.println("Before Controller Layer " + joinPoint.getSignature().getName());
    }
    @After("inControllerLayer()")
    public void afterControllerLayer(JoinPoint joinPoint){
        System.out.println("After Controller Layer" + joinPoint.getSignature().getName());
    }
    @Pointcut("within(com.example.BookHW.controller..*)")
    public void inControllerLayer(){}

    @Before("inServiceLayer()")
    public void beforeServiceLayer(JoinPoint joinPoint){
        System.out.println("Before Service Layer " + joinPoint.getSignature().getName());
    }
    @After("inServiceLayer()")
    public void afterServiceLayer(JoinPoint joinPoint){
        System.out.println("After Service Layer" + joinPoint.getSignature().getName());
    }
    @Pointcut("within(com.example.BookHW.service..*)")
    public void inServiceLayer(){}


}
