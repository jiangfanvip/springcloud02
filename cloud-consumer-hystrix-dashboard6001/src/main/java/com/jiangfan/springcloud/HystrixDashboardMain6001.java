package com.jiangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * ClassName: HystrixDashboardMain6001
 * Description:
 * date: 2020-8-8 15:34
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableHystrixDashboard //开启histrix dashboard
public class HystrixDashboardMain6001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain6001.class, args);
    }
}
