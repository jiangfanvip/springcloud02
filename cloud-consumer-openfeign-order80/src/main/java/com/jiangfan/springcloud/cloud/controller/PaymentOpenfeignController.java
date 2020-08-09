package com.jiangfan.springcloud.cloud.controller;

import com.jiangfan.springcloud.cloud.service.PaymentOpenfeignService;
import com.jiangfan.springcloud.entitys.CommonResult;
import com.jiangfan.springcloud.entitys.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: PaymentOpenfeignController
 * Description:
 * date: 2020-8-6 21:37
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@RestController
@Slf4j
public class PaymentOpenfeignController {
    @Autowired
    private PaymentOpenfeignService paymentOpenfeignService;

    @GetMapping(value = "/openfeign/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {

        return paymentOpenfeignService.getPaymentById(id);
    }

    @PostMapping(value = "/openfeign/createOrder")
    public CommonResult<Long> createOrder(Payment payment) {
        return paymentOpenfeignService.insertPayment(payment);
    }
    @GetMapping(value = "/openfeign/getPort")
    public String getPort() {

        return paymentOpenfeignService.getPort();
    }
}
