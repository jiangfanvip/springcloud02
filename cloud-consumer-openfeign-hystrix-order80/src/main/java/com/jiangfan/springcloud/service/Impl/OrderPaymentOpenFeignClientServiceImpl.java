package com.jiangfan.springcloud.service.Impl;

import com.jiangfan.springcloud.service.OrderPaymentOpenFeignClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

/**
 * ClassName: OrderPaymentOpenFeignClientServiceImpl
 * Description:
 * date: 2020-8-7 23:30
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Component  //注册到ioc容器中
public class OrderPaymentOpenFeignClientServiceImpl  implements OrderPaymentOpenFeignClientService {
    @Override
    public String payment_ok(Integer id) {
        return "payment_ok------------降级处理"+id;
    }
    @Override
    public String payment_timeout(Integer id) {
        return "payment_timeout------------降级处理"+id;
    }
}
