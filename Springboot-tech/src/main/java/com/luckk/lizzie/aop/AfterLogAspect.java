package com.luckk.lizzie.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class AfterLogAspect implements AfterReturningAdvice {
    @Override
//    @Pointcut()
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {

        System.out.println("方法执行之后执行，该切面仅仅能用bean进行定义");
    }
}
