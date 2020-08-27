package com.jiangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

/**
 * ClassName: StreamRabbitMqProviderMain8801
 * Description:
 * date: 2020-8-10 0:07
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitMqProviderMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMqProviderMain8801.class, args);
    }
}
