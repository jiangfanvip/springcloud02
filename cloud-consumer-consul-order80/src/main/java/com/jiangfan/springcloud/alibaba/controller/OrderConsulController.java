package com.jiangfan.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: OrderConsulController
 * Description:
 * date: 2020-8-6 1:23
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@RestController
public class OrderConsulController {
    public static final String INVOKE_URL = "http://consul-provider-payment";
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/consul/payment")
    public String paymentInfo() {
        String val = restTemplate.getForObject(INVOKE_URL + "/consul", String.class);
        return val;
    }
}
