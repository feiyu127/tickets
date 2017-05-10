package com.tickets;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.test.context.transaction.AfterTransaction;

@Aspect
@Component
public class MyAspect
{
    
    @Pointcut("execution(* com.tickets..*(..))")
    public void record()
    {
        System.out.println("record------");
    };
    
    @After("record()")
    public void after(JoinPoint jp)
    {
        System.out.println("after-- ");
    }
    
    @AfterReturning("record()")
    public void afterReturning(JoinPoint jp)
    {
        System.out.println("afterReturning-- ");
    }
    
    @Before("record()")
    public void before(JoinPoint jp)
    {
        System.out.println("before-- ");
    }
    @AfterThrowing("record()")
    public void afterThrowing(JoinPoint jp)
    {
        System.out.println("afterThrowing-- ");
    }
    
//    @Around("record()")  
//    public void around(ProceedingJoinPoint pjp) throws Throwable{  
//        System.out.println("已经记录下操作日志@Around 方法执行前");  
//        pjp.proceed();  
//        System.out.println("已经记录下操作日志@Around 方法执行后");  
//    }  
}
