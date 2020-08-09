package com.jiangfan.springcloud.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.jiangfan.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: PaymentServiceImpl
 * Description:
 * date: 2020-8-7 0:28
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    public String payment_ok(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "payment_ok==" + id;
    }

    //-----------提供者service层方法自身执行超时或者发生异常,都会导致提供者自身服务降级，调用兜底方法----------------------------
    //@HystrixCommand服务降级fallbackMethod：兜底方法，这个提供者接口出问题了就会调用所设定的兜底方法来兜底，commandProperties 设定自身  执行超时规则
    //@HystrixProperty name = "execution.isolation.thread.timeoutInMilliseconds"  value=3000 当前线程执行时间 3000毫秒,超过3000毫秒则由paymentInfoHandlderMethod兜底
    // ------------------------------------
    @HystrixCommand(fallbackMethod = "paymentInfoHandlderMethod", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    @Override
    public String payment_timeout(Integer id) {
        //  -----------方法异常模拟
        //  int  a=10/0;
        //--------------------------超时模拟
        try {
            int a = 3000;
            Thread.sleep(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "payment_timeout===" + id;

    }

    public String paymentInfoHandlderMethod(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "payment_timeout===" + id + "------超时,请稍后再试--------------";
    }


    //------------------------------服务的熔断
    //10秒内请求10次，达到了60%的失败率则触发熔断机制(就是10次请求6次以上的失败 )
    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器 true开启
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //10000毫秒时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后跳闸
    }
    )
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id不能为负数");
        }
        String simpleUUID = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "成功调用，流水号是：" + simpleUUID;
    }
    /**
     * 兜底方法
     * @param id
     * @return
     */
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id不能为负数，请稍后再试............" + id;
    }
}
