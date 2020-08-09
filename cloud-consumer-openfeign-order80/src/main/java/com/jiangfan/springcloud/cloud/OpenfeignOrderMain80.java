package com.jiangfan.springcloud.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: OpenfeignOrderMain80
 * Description:
 * date: 2020-8-6 21:12
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableFeignClients  //消费者的启动类标注以openFeign的方式去调用提供者微服务
public class OpenfeignOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignOrderMain80.class, args);
    }
}
