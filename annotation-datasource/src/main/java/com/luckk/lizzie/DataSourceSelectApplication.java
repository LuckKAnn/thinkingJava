package com.luckk.lizzie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy
public class DataSourceSelectApplication {

    public static void main(String[] args) {

        SpringApplication.run(DataSourceSelectApplication.class);

    }
}
