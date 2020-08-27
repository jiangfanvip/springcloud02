package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * ClassName: ReceiveMessageController
 * Description:
 * date: 2020-8-10 14:46
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Component
@EnableBinding(Sink.class)  //消费者开启绑定   绑定一个输入通道
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)   //监听流
    public void input(Message<String> message) {
        System.out.println("消息1.。。。。。。。。。"+port+"。。。。" + message.getPayload()); //获取消息体内容
    }

}
