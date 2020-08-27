package com.jiangfan.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jiangfan.springcloud.alibaba.service.PaymentService;

import com.jiangfan.springcloud.entitys.CommonResult;
import com.jiangfan.springcloud.entitys.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {

    @Value("${server.port}")
    private String serverPost;

    public static final String SERVICE_URL="http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
  //@SentinelResource(value = "fallback")  //没有配置,直接抛出异常给客户端
  //@SentinelResource(value = "fallback",fallback = "handlerFallback")  //fallback只负责业务异常
 // @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentine控制台配置违规,还没达到配置违规时候就会抛java异常到客户端,达到了违规异常时则自定义方法处理
   @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler") //handlerFallback和blockHandler都配置
    //exceptionsToIgnore配置\
   // @SentinelResource(value = "fallback",fallback = "handlerFallback")管Java程序发生逻辑异常（运行时异常）了 设置兜底方法
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler") //管理负责sentinel 配置违规
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL+"/paymentSQL/"+id,CommonResult.class,id);
        if (id==4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }

    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult(444,"兜底异常handlerFallback,exception内容"+e.getMessage(),payment);
    }

    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException exception) {
        Payment payment = new Payment(id,"null");
        return new CommonResult(445,"兜底异常blockHandler,exception内容"+exception.getMessage(),payment);
    }

    //--------------Openfeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
}
