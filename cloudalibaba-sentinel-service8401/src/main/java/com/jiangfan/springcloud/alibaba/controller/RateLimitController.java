package com.jiangfan.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import com.jiangfan.springcloud.entitys.CommonResult;
import com.jiangfan.springcloud.entitys.Payment;
import com.jiangfan.springcloud.myhandler.Customerhandler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {
    /**
     *  缺点：
     * 1  兜底方案和我们业务代码所吻合
     * 2  每一个业务方法都需要一个兜底方法，增加了多余代码  自定义兜底方法
     */

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }
    //兜底方法
    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t服务不可用");
    }
    /**
     * 按照URL 限流  默认方法处理
     * @return
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200,"按URL限流测试OK",new Payment(2020L,"serial002"));
    }


    /**
     * 自定义错误消息返回
     * 解决了每个代码业务偶尔 每个业务方法要多兜底方法
     * @return
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = Customerhandler.class,
            blockHandler = "handlerException")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200,"按客户自定义OK",new Payment(2020L,"serial003"));
    }
}
