package com.jiangfan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: springcloudalibabaCloudalibabaConfigClientMain3377
 * Description:
 * date: 2020-8-11 13:49
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3377.class, args);
    }
}
