package springalibabacloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: PaymentController
 * Description:
 * date: 2020-8-11 11:28
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/nacos/consumer")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    public String remoteURI;

    @GetMapping("/getPaymentId/{id}")
    public  String  getPaymentId(@PathVariable Integer id){
        String str = restTemplate.getForObject(remoteURI + "/payment/getPayment/"+id, String.class);
        return  str;
    }
}
