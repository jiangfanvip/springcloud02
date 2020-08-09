package com.jiangfan.springcloud.controller;

import com.jiangfan.springcloud.service.OrderPaymentOpenFeignClientService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OpenFeignClientPaymentController
 * Description:
 * date: 2020-8-7 11:10
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_fallbackMethod")  //全局服务降级处理
public class OrderPaymentOpenFeignClientController {
    @Autowired
    private OrderPaymentOpenFeignClientService openFeignClientPaymentService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id) {
        String s = openFeignClientPaymentService.payment_ok(id);
        log.info(s);
        return s;
    }

    //消费者客户端controller层@HystrixCommand服务降级，fallbackMethod：兜底方法,commandProperties服务降级触发规则
    //@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500") 具体规则
    // 调用时间超过1500毫秒则触发服务降级调用兜底方法
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "orderInfoHandlderMethod",
//            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
  //@HystrixCommand
    public String payment_timeout(@PathVariable("id") Integer id) {
        //模拟异常
         // int a = 10 / 0;
        String s = openFeignClientPaymentService.payment_timeout(id);
        log.info(s);
        return s;

    }

    /**
     * 单个服务降级方法
     *
     * @param id
     * @return
     */
    public String orderInfoHandlderMethod(@PathVariable Integer id) {
        return "我是消费者：80----线程池:" + Thread.currentThread().getName() + "payment_timeout==="
                + id + "--order----超时,请稍后再试--------------";
    }

    /**
     * 全局服务降级方法
     *
     * @return
     */
    public String payment_Global_fallbackMethod() {
        return "Global_fallbackMethod....全局服务降级处理";
    }

}
