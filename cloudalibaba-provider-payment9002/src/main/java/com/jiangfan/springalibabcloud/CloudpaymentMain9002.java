package com.jiangfan.springalibabcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: CloudpaymentMain9001
 * Description:
 * date: 2020-8-11 10:19
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudpaymentMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudpaymentMain9002.class,args);
    }
}
