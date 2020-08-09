package com.jiangfan.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: PaymentService
 * Description:
 * date: 2020-8-7 0:28
 *
 * @author LENOVO
 * @since JDK 1.8
 */
public interface PaymentService {
    public String payment_ok(Integer id);

    public String payment_timeout(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
