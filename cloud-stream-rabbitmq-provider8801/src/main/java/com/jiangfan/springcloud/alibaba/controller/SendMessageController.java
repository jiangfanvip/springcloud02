package com.jiangfan.springcloud.alibaba.controller;

import com.jiangfan.springcloud.service.IMessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: SendMessageController
 * Description:
 * date: 2020-8-10 12:35
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@RestController
public class SendMessageController {
    @Autowired
    private IMessageProviderService iMessageProviderService;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return iMessageProviderService.send();
    }
}
