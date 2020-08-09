package com.jiangfan.myIrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MyIruleConfig
 * Description:
 * date: 2020-8-6 15:51
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Configuration
public class MyIruleConfig {
    @Bean
    public IRule myIrule() {
        return new RandomRule();  //定义为随机策略
    }
}
