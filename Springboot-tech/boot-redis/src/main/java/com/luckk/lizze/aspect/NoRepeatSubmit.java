package com.luckk.lizze.aspect;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface NoRepeatSubmit {

    boolean canRepeat() default false;


}
