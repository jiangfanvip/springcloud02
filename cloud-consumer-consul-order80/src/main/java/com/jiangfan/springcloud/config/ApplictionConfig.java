package com.jiangfan.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: ApplictionConfig
 * Description:
 * date: 2020-8-3 2:13
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Configuration
public class ApplictionConfig {
    /**
     * 注册restTemplate bean
     */
    @Bean
    @LoadBalanced //一个应用程序微服务是集群环境的话，消费端通过应用程序名调用的话必须要把restTemplate设置为负载均衡策略
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    ;
}
