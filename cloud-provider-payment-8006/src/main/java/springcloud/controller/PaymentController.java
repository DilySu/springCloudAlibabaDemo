package springcloud.controller;

import com.dily.springcloud.entities.Payment;
import com.dily.springcloud.reponse.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springcloud.service.PaymentService;

import java.util.List;
import java.util.UUID;

/**
 * Date: 2022-10-27 星期四
 * Time: 14:49
 * Author: Dily_Su
 * Remark:
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consul")
    public String consul(){
        return "spring cloud with consul"+ serverPort +"\t" + UUID.randomUUID();
    }

    @GetMapping("/get/{id}")
    public BaseResponse<?> getById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("*************查询结果：" + result);
        if (result != null) {
            return new BaseResponse<>(200, "success：" + serverPort, result);
        } else {
            return new BaseResponse<>(444, "fail，id not exist" + serverPort, id);
        }
    }

    @PostMapping("/create")
    public BaseResponse<?> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*************插入结果：" + result);
        if (result > 0) {
            return new BaseResponse<>(200, "success" + serverPort, result);
        } else {
            return new BaseResponse<>(444, "fail" + serverPort, null);
        }
    }

    @GetMapping("/discover")
    public Object discover() {
        List<String> serverLists = discoveryClient.getServices();
        serverLists.forEach(e -> log.info("*****electment:" + e));
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment");
        instances.forEach(e -> log.info(e.getServiceId() + '\t' + e.getHost() + '\t' + e.getPort() + '\t' + e.getUri()));
        return this.discoveryClient;
    }
}
