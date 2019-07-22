package com.spring.cn.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类，基于手动事务封装
 */
@Component
@Aspect
public class AopLog {

    /**
     * 前置通知
     */
    @Before("execution(* com.spring.cn.test.aop.service.UserService.add(..))")
    public void before(){
        System.out.println("---- 前置通知，在方法之前执行 ----");
    }

    /**
     * 后置通知
     */
    @After("execution(* com.spring.cn.test.aop.service.UserService.add(..))")
    public void after(){
        System.out.println("---- 后置通知，在方法之后执行 ----");
    }

    @AfterReturning("execution(* com.spring.cn.test.aop.service.UserService.add(..))")
    public void returning(){
        System.out.println("---- 运行通知，在方法运行执行 ----");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("execution(* com.spring.cn.test.aop.service.UserService.add(..))")
    public void afterThrowing(){
        System.out.println("---- 异常通知，在方法异常执行 ----");
    }

    /**
     * 环绕通知
     */
    @Around("execution(* com.spring.cn.test.aop.service.UserService.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("---- 环绕通知，调用方法之前执行 ----");
        // 代理调用方法 注意点： 如果调用方法抛出溢出不会执行后面代码
        proceedingJoinPoint.proceed();
        System.out.println("---- 环绕通知，调用方法之后执行 ----");
    }
}
