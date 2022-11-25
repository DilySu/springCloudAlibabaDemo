spring cloud alibaba 全套学习代码
- 注册中心 eureka、consul、zookeeper
- 负载均衡 ribbon
- 服务调用 openFeign
- 熔断器 hystrix、 熔断器仪表盘 hystrix-dashboard
- 配置中心 config、消息总线 bus
- 消息驱动 stream
- 阿里巴巴：nacos、sentinel、seata

## common
    通用实体
# 一、注册中心
## cloud-eureka-7071、cloud-eureka-7072
    模拟注册中心集群，相互注册

# 二、服务消费者
## cloud-consumer-order-8081、cloud-consumer-order-8082
    模拟服务消费者集群, 向 eureka 中注册，获取服务列表
- 负载均衡：eureka client 中集成了 ribbon
- 服务调用：RestTemplate
## cloud-consumer-order-feign-8083
    在服务消费端使用 openFeign 实现服务调用 
## cloud-consumer-order-feign-hystrix-8084
    在服务消费端使用 openFeign 实现服务调用，使用 Hystrix 实现服务降级和服务熔断

# 三、服务提供者
## cloud-provider-payment-8001、cloud-provider-payment-8002
    模拟服务提供者集群, 向 eureka 中注册，获取服务列表
## cloud-provider-payment-8004
    模拟服务提供者, 向 zookeeper 中注册，获取服务列表
## cloud-provider-payment-8006
    模拟服务提供者, 向 consul 中注册，获取服务列表
## cloud-provider-payment-hystrix-8008
    在服务端提供端实现服务降级、服务熔断

# 四、配置中心
## cloud-config-3344 
    配置中心服务端，实现广播刷新、定点刷新
## cloud-config-client-3355、## cloud-config-client-3366
    配置中心客户端

# 五、消息驱动：以 rabbitmq 为例
## cloud-stream-rabbitmq-provider-8880 
    消息驱动，消息生产者
## cloud-stream-rabbitmq-consumer-8881、cloud-stream-rabbitmq-consumer-8882
    消息驱动，消息消费者，通过分组（队列），避免同步消费

# 六、分布式链路追踪
    使用 cloud-consumer-order-8081 调用 cloud-provider-payment-8001、cloud-provider-payment-8002 进行测试
# 七、alibaba 组件
## cloud-alibaba-nacos-consumer-9999
    nacos 消费者，内部集成了ribbon，可直接实现负载均衡
## cloud-alibaba-nacos-consumer-9001、cloud-alibaba-nacos-consumer-9002
    nacos 服务提供者
## cloud-alibaba-nacos-config-client-3377
    nacos 配置中心 客户端，使用 nacos 中的远程配置文件
## cloud-alibaba-sentinel-service-8401
    sentinel 实现熔断限流
## cloud-alibaba-sentinel-ribbon-consumer-8884
    sentinel + ribbon 实现负载均衡、服务降级熔断限流 
## cloud-alibaba-sentinel-openfeign-consumer-8885
    sentinel + openfeign 实现负载均衡、服务降级熔断限流

# Docker 中部署 nocas、sentinel
## nacos-docker 
    dokcer 中部署 nacos 的教程及相关材料
## sentinel-docker 
    docker 中部署 sentinel 的 docker-compose