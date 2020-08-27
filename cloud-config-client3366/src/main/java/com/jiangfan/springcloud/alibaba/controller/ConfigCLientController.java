package com.jiangfan.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ConfigCLientController
 * Description:
 * date: 2020-8-9 17:30
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@RestController
@RefreshScope
public class ConfigCLientController {
    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/configInfo")
    public String getConfigInfo() {
        return "serverPort" + serverPort + "\t\n\nconfigInfo" + this.configInfo;
    }
}
