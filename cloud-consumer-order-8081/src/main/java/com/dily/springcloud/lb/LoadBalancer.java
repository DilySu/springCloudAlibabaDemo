package com.dily.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Date: 2022-11-03 星期四
 * Time: 13:54
 * Author: Dily_Su
 * Remark:
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
