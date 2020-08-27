package com.jiangfan.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * sentinel默认返回错误消息 服务降级
 */
@RestController
@Slf4j
public class FlowLimitController {

    @RequestMapping("testA")
    public String testA() {

        return "testA-------";
    }

    @RequestMapping("testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "----" + "testB");
        return "testB-------";
    }

    @RequestMapping("testD")
    public String testD() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // log.info(Thread.currentThread().getName()+"----"+"testD");
        log.info("异常......");
        int age = 10 / 0;
        return "testD-------";
    }

    @RequestMapping("testE")
    public String teste() {

        log.info("异常数......");
        int age = 10 / 0;
        return "testD-------";
    }

    @GetMapping("/hotKey")
    //如果sentinel web页面资源名也可以配置为/hotKey或者hotKey,value: 唯一名称,blockHandler 指定兜底方法名
    @SentinelResource(value = "hotKey", blockHandler = "deal_testHostKey")
    public String hotKey(@RequestParam(value = "p1", required = false) String p1,
                         @RequestParam(value = "p2", required = false) String p2) {
        System.out.println("p1============" + p1 + "\t");
        System.out.println("p2============" + p2 + "\t");
        return "--------test hot key.....";
    }

    /**
     * 兜底方法
     */
    public String deal_testHostKey(String p1, String p2, BlockException ex) {
        return "--------deal_testHostKey.....";

    }
}
