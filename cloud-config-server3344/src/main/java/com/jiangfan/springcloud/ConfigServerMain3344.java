package com.jiangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * ClassName: ConfigServerMain3344
 * Description:
 * date: 2020-8-9 12:50
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableConfigServer  //激活配置中心
public class ConfigServerMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMain3344.class,args);
    }
}
