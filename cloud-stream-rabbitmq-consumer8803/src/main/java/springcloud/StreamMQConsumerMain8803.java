package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ClassName: StreamMQConsumerMain8802
 * Description:
 * date: 2020-8-10 14:43
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQConsumerMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQConsumerMain8803.class, args);
    }
}
