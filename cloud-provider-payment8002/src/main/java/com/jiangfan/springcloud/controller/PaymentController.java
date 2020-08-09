package com.jiangfan.springcloud.controller;

import com.jiangfan.springcloud.entitys.CommonResult;
import com.jiangfan.springcloud.entitys.Payment;
import com.jiangfan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: PaymentController
 * Description:
 * date: 2020-8-2 23:03
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@RequestMapping("/payment")
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    //支付的提供者应用程序名cloud-payment-provider-service是集群环境，所以通过这个端口来判断负载均衡调用到哪一个集群下的服务
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getPort")
    public String getPort() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return serverPort;
    }

    @GetMapping("/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("查询结果*************id====" + id);
        Payment payment = paymentService.getPaymentById(id);
        CommonResult<Payment> result = new CommonResult<>();
        if (payment != null) {
            result.setCode(0);
            result.setMesage("查询成功:port=" + serverPort);
            result.setData(payment);
        } else {
            result.setCode(-2);
            result.setMesage("查询为null,支付流水号不存在:port=" + serverPort);
        }

        return result;
    }

    @PostMapping("/createPayment")
    public CommonResult<Long> insertPayment(@RequestBody Payment payment) {
        log.info("新增************payment====" + payment);
        Long id = paymentService.insertPayment(payment);
        CommonResult<Long> commonResult = new CommonResult<>();
        if (id > 0) {
            return new CommonResult<Long>(0, "支付成功:port=" + serverPort, id);

        } else {
            return new CommonResult<Long>(-1, "支付失败:port=" + serverPort);
        }
    }


}
