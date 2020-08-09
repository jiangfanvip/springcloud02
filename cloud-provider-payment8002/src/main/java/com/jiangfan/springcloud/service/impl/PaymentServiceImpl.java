package com.jiangfan.springcloud.service.impl;

import com.jiangfan.springcloud.dao.PaymentDao;
import com.jiangfan.springcloud.entitys.Payment;
import com.jiangfan.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: PaymentServiceImpl
 * Description:
 * date: 2020-8-2 23:00
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public  Long insertPayment(Payment payment) {
        paymentDao.insertPayment(payment);
        return payment.getId();

    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
