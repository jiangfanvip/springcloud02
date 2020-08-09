package com.jiangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ClassName: EurekaServerMain7001
 * Description:
 * date: 2020-8-4 1:54
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@EnableEurekaServer   //7002端口启动类需要标注这个注解表示是eureka server
@SpringBootApplication
public class EurekaServerMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain7002.class, args);
    }
}
