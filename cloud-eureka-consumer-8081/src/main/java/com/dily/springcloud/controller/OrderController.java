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
     public static final String PAYMENT_URL = "http://localhost:8001";
//    public static final String PAYMENT_URL = "http://cloud-payment";

    @Autowired
    private LoadBalancer loadBalancer; // 自定义的负载均衡策略
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient; // 服务发现客户端，用于从注册中心获取服务信息

    @PostMapping("/create")
    public BaseResponse<?> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, BaseResponse.class);
    }

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
     */
    @GetMapping("/lb")
    public String getLB() {
        // 从注册中心获取 服务列表
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("cloud-payment");
        if (serviceInstances == null || serviceInstances.size() <= 0) {
            return null;
        }
        // 使用自定义的负载均衡策略选择服务
        ServiceInstance instances = loadBalancer.instances(serviceInstances);
        URI uri = instances.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    /**
     * 分布式链路追踪测试
     */
    @GetMapping("zipkin")
    public String zipkin() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
    }
}
