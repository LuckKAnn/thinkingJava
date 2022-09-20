package com.luckk.lizzie.springsecurity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
@Slf4j
class SpringsecurityApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testAssert(){
        System.out.println("yes");

        log.warn("hello");
        Assert.state(true,"hello");

    }

    @Test
    void testAssert2(){
        System.out.println("yes");

    }
}
