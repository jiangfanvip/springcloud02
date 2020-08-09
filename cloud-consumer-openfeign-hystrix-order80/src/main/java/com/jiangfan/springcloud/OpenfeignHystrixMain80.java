package com.jiangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: openfeignHystrixMain80
 * Description:
 * date: 2020-8-7 11:06
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OpenfeignHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignHystrixMain80.class, args);
    }
}
