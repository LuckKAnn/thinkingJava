package com.luckk.lizzie.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {


    @RequestMapping("/hello")
    @PreAuthorize("hasAnyAuthority('test')")
    public String hello(){
        List<Object> objects = Collections.emptyList();
        if (log.isTraceEnabled()){

        }

        log.info("get an request hello");
        return "hello lkk";
    }

    @RequestMapping("/hello2")
    public String hello2(){
        log.info("get an request hello2");

        return "hello lkk";
    }

}
