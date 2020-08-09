package com.jiangfan.springcloud;

import com.jiangfan.myIrule.MyIruleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

import javax.naming.Name;

/**
 * ClassName: OrderMain80
 * Description:
 * date: 2020-8-3 1:30
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@EnableEurekaClient
@SpringBootApplication
//设置消费者访问name=cloud-payment-provider-service微服务，configuration 指定负载均衡算法规则
//@RibbonClient(name = "cloud-payment-provider-service",configuration = MyIruleConfig.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
