package com.jiangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ClassName: PaymentProviderMain8001
 * Description:
 * date: 2020-8-2 21:53
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@EnableEurekaClient  //微服务提供者需要注册到eureka server,所以作为eureka客户端要修饰这个注解
@SpringBootApplication
public class PaymentProviderMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProviderMain8002.class, args);
    }
}
