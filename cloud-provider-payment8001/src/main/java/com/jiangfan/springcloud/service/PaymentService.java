package com.jiangfan.springcloud.service;

import com.jiangfan.springcloud.entitys.Payment;

/**
 * ClassName: service
 * Description:
 * date: 2020-8-2 22:56
 *
 * @author LENOVO
 * @since JDK 1.8
 */
public interface PaymentService {
    public  Long insertPayment(Payment payment);

    public Payment getPaymentById(Long id);
}
