package com.jiangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: OraderConsulMain80
 * Description:
 * date: 2020-8-6 1:18
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@SpringBootApplication
//@EnableDiscoveryClient
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class, args);
    }

}
