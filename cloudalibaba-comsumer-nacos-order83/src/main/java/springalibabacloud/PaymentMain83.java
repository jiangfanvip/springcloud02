package springalibabacloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: PaymentMain83
 * Description:
 * date: 2020-8-11 11:26
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain83 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain83.class, args);
    }
}
