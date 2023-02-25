package com.luckk.lizzie;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// 如果引入了druid数据源，它还会默认扫描数据源，需要进行排除
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
public class SpringBootRunApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRunApplication.class);
    }
}
