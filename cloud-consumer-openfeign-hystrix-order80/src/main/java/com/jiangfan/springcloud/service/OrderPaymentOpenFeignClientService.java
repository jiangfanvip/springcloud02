package com.jiangfan.springcloud.service;

import com.jiangfan.springcloud.service.Impl.OrderPaymentOpenFeignClientServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: OpenFeignClientPaymentService
 * Description:
 * date: 2020-8-7 11:08
 *
 * @author LENOVO
 * @since JDK 1.8
 */
//------------------在消费者service客户端调用层就做了服务降级，所以不需要在controller层做了-------------------
//fallback = OrderPaymentOpenFeignClientServiceImpl.class 是OrderPaymentOpenFeignClientService的实现类
    //使用feignFallback处理统一当前service客户端接口的降级处理，降级处理对这个service的所有方法都生效
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = OrderPaymentOpenFeignClientServiceImpl.class)
public interface OrderPaymentOpenFeignClientService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id);

}
