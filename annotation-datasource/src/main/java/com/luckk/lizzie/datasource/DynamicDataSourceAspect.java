package com.luckk.lizzie.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class DynamicDataSourceAspect {


    @Pointcut("@annotation(com.luckk.lizzie.datasource.DataSourceSelector)")
    public void checkPointCut() {
    }

    @Before("checkPointCut()")
    public void setDatasource(JoinPoint joinPoint)  {
        // 反射获取
        try {
            Class<?> clazz = joinPoint.getTarget().getClass();
            String methodName = joinPoint.getSignature().getName();
            Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
            Method method = clazz.getMethod(methodName, parameterTypes);
            DataSourceSelector selector = method.getAnnotation(DataSourceSelector.class);
            String value = selector.value();
            DataSourceContextHolder.setDataSourceContextHolder(value);
        }catch (NoSuchMethodException noSuchMethodException){
            noSuchMethodException.printStackTrace();
        }

    }

    @After("checkPointCut()")
    public void clearDatasource() {

    }


}
