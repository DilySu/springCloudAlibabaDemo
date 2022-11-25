package com.dily.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Date: 2022-11-03 星期四
 * Time: 13:55
 * Author: Dily_Su
 * Remark: 自定义负载均衡策略
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取当前轮到的服务
     * 轮询策略
     *
     * @param serviceInstances 所有可用服务列表
     * @return 服务
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        return serviceInstances.get(getAndIncrement() % serviceInstances.size());
    }

    /**
     * 获取当前请求次数
     *
     * @return next
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("******************next" + next);
        return next;
    }

}
