package com.jiangfan.springcloud.cloud.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: FeignConfig
 * Description:
 * date: 2020-8-6 23:13
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;

    }
}
