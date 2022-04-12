package com.luckk.lizzie;

import com.luckk.lizzie.servlet.HelloServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @FileName: EmbedTomcatTest
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/29 10:17
 */

/**
 * 怎么启动起来的:
 * tomcat通过内嵌的启动
 * 然后其SPI机制，能够发现QuickAppStarter，生效并创建IOC容器，配置DispatcherServlet等各种组件
 *
 * 剩下的就是springboot做了一些自动配置
 */
@SpringBootApplication

public class EmbedTomcatTest {


    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8888);
        tomcat.setHostname("localhost");
        tomcat.setBaseDir(".");
        tomcat.addWebapp("/boot",System.getProperty("user.dir")+"/framework/src/main");
        Wrapper hello = tomcat.addServlet("/boot", "hello", new HelloServlet());
        hello.addMapping("/test");
        tomcat.start();
        tomcat.getServer().await();

    }
}
