package com.jiangfan.springcloud.controller;

import com.jiangfan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.logging.Logger;

/**
 * ClassName: PaymentController
 * Description:
 * date: 2020-8-7 0:34
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String prot;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id) {
        String s = paymentService.payment_ok(id);
        log.info(s);
        return s;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id) {
        String s = paymentService.payment_timeout(id);
        log.info(s);
        return s;

    }

    /**
     * 服务熔断
     *
     * @return
     */
    @GetMapping("/payment/hystrix/paymentCirucitBreaker/{id}")
    public String paymentCirucitBreaker(@PathVariable("id") Integer id) {
        String s = paymentService.paymentCircuitBreaker(id);
        log.info("*************服务熔断****" + s);
        return s;
    }

}
