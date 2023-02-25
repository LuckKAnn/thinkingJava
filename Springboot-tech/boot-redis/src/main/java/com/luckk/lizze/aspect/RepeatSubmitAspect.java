package com.luckk.lizze.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepeatSubmitAspect {

    private  final RedisTemplate redisTemplate;

    public RepeatSubmitAspect(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Pointcut("@annotation(NoRepeatSubmit)")
    public  void pointCut(){

    }


    @Before("pointCut()")
    public  void preventRepeatSubmit(){

//        redisTemplate.opsForValue().set();
    }
}
