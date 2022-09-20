package com.luckk.lizzie.springsecurity.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {



    @ExceptionHandler(Exception.class)
    public void handleNormalException(){

    }



}
