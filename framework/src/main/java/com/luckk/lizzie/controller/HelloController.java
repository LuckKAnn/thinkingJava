package com.luckk.lizzie.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @FileName: HelloController
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/29 10:31
 */
@RestController
public class HelloController {



    @RequestMapping("/hello")
    public String Hello(){
        return "6666";
    }
}
