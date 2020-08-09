package com.jiangfan.springcloud.cloud.service;

import com.jiangfan.springcloud.entitys.CommonResult;
import com.jiangfan.springcloud.entitys.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ClassName: paymentService
 * Description:
 * date: 2020-8-6 21:21
 *
 * @author LENOVO
 * @since JDK 1.8
 */
//标注这是一个feignCLient的类,它会调用name="微服务应用程序名"对应的提供者微服务
@FeignClient(name = "cloud-payment-provider-service") //调用cloud-payment-provider微服务
public interface PaymentOpenfeignService {
    @GetMapping("/payment/createPayment") //请求cloud-payment-provider-service微服务的controller暴露地址
    public CommonResult<Long> insertPayment(Payment payment);

    @GetMapping("/payment/getPayment/{id}")//请求cloud-payment-provider-service微服务的controller暴露地址
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/getPort")
    public String getPort();


}
