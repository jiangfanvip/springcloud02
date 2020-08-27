package com.jiangfan.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: RabbitMqConfig
 * Description:
 * date: 2020-8-10 9:50
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue springCloudBus(){

        return  new Queue("springCloudBus.anonymous.SicV6Z2rTlGTSxmnvXTEQQ");
    }
}
