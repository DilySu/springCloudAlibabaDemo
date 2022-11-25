package com.dily.springcloud.controller;

import com.dily.springcloud.entities.Payment;
import com.dily.springcloud.lb.LoadBalancer;
import com.dily.springcloud.reponse.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Date: 2022-10-27 星期四
 * Time: 15:56
 * Author: Dily_Su
 * Remark:
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    // 单机版本
    // public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://cloud-payment";

    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public BaseResponse<?> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, BaseResponse.class);
    }

    /**
     * getForObject
     */
    @GetMapping("/get/{id}")
    public BaseResponse<?> getById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, BaseResponse.class);
    }

    /**
     * getForEntity
     * 返回 ResponseEntity
     */
    @GetMapping("/entity/{id}")
    public BaseResponse<?> entity(@PathVariable("id") Long id) {
        ResponseEntity<BaseResponse> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, BaseResponse.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new BaseResponse<>(444, "fail");
        }
    }

    /**
     * 自定义的负载均衡
     *
     */
    @GetMapping("/lb")
    public String getLB() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("cloud-payment");
        if (serviceInstances == null || serviceInstances.size() <= 0) {
            return null;
        }

        ServiceInstance instances = loadBalancer.instances(serviceInstances);
        URI uri = instances.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
