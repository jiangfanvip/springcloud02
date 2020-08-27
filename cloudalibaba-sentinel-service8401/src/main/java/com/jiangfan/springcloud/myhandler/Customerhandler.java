package com.jiangfan.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jiangfan.springcloud.entitys.CommonResult;
import com.jiangfan.springcloud.entitys.Payment;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 自定义限流处理类
 */

public class Customerhandler {
    /**
     * 自定义返回错误消息方法1
     * @param exception
     * @    return
     */
    public CommonResult handlerException1(BlockException exception) {
        return new CommonResult(-1, "按客户自定义，global handlerException------------1");
    }

    /**
     * 自定义返回错误消息方法2
     * @param exception
     */

     public CommonResult handlerException2(BlockException exception) {
        return new CommonResult(-1, "按客户自定义，global handlerException-----------2");
    }
}
