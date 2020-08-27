package com.jiangfan.springcloud.alibaba.controller;

import com.jiangfan.springcloud.entitys.CommonResult;
import com.jiangfan.springcloud.entitys.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * ClassName: OrderController
 * Description:
 * date: 2020-8-3 2:14
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@RequestMapping("/consumer")
@RestController
@Slf4j
public class OrderController {
    //public static final String remoteUrl = "http://localhost:8001";
    public static final String remoteUrl = "http://cloud-payment-provider-service";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/orderPaymentZipkin")
    public String orderPaymentZipkin() {
        return restTemplate.getForObject(remoteUrl + "/payment/zipkin", String.class);

    }

    @GetMapping("/orderCreate")
    public CommonResult<Long> orderPayment(Payment payment) {
        //参数1  URL      参数2  实参对象           3 返回结果的class对象
        return restTemplate.postForObject(remoteUrl + "/payment/createPayment", payment, CommonResult.class);
    }

    @GetMapping("/getPayment/{id}")
    public CommonResult<Payment> queryPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(remoteUrl + "/payment/getPayment/" + id, CommonResult.class);

    }

    @GetMapping("/getForEntityPayment/{id}")
    public CommonResult<Payment> getForEntityPayment(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(remoteUrl + "/payment/getPayment/" + id, CommonResult.class);
        boolean xxSuccessful = entity.getStatusCode().is2xxSuccessful();
        log.info("------------" + entity.getHeaders().get("Connection"));
        if (xxSuccessful) {
            return entity.getBody();
        } else {
            return new CommonResult<>(-1, "调用失败");

        }
    }
}
