package com.jiangfan.springcloud.service.Impl;

import com.jiangfan.springcloud.service.IMessageProviderService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * ClassName: IMessageProviderServiceImpl
 * Description:发送消息的实现
 * date: 2020-8-10 0:41
 *
 * @author LENOVO
 * @since JDK 1.8
 */
//开启一个绑定，绑定这个source.class代表消息源输出通道（一个生产者输出通道）,
@EnableBinding(Source.class)
@Slf4j
public class IMessageProviderServiceImpl implements IMessageProviderService {
    @Autowired
    @Qualifier("output")
    private MessageChannel output; //声明消息发送通道
    @Auto
    ApplicationContext applicationContext;

    @Override
    public String send() {
        log.info(output.getClass().getName());
        String uuid = UUID.randomUUID().toString();  //消息内容
        log.info(uuid + "...............");
        MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(uuid);//消息构造并往消息体设置发送内容
        Message<String> build = stringMessageBuilder.build();  //构造message
        output.send(build);//发送消息
        return uuid;

    }
}
