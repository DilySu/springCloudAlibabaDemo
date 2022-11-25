spring cloud alibaba 全套学习代码
- 注册中心 eureka、consul、zookeeper
- 负载均衡 ribbon
- 服务调用 openFeign
- 熔断器 hystrix、 熔断器仪表盘 hystrix-dashboard
- 配置中心 config、消息总线 bus
- 消息驱动 stream
- 阿里巴巴：nacos、sentinel、seata

# 一、 spring cloud 组件
## 1.1 注册中心
### eureka
> eureka client 中集成了 ribbon，故支持负载均衡，可使用 RestTemplate 进行服务调用
- 注册中心集群: cloud-eureka-7071、cloud-eureka-7072
- 服务提供者：cloud-eureka-provider-8001、cloud-eureka-provider-8002
- 服务消费者：cloud-eureka-consumer-8081、cloud-eureka-consumer-8082
### consul
> 模拟服务提供者, 向 consul 中注册，获取服务列表
- 注册中心集群: 本地搭建 consul 集群
- 服务提供者：cloud-consul-provider-8006
### zookeeper
> 模拟服务提供者, 向 zookeeper 中注册，获取服务列表
- 注册中心集群: 本地搭建 zookeeper 集群
- 服务提供者：cloud-zookeeper-provider-8004

## 1.2 声明式服务调用
### openfeign
> 在服务消费端使用 openFeign 实现服务调用
- 消费者：cloud-eureka-consumer-feign-8083
- 注册中心集群: cloud-eureka-7071、cloud-eureka-7072
- 服务提供者：cloud-provider-payment-8001、cloud-provider-payment-8002

## 1.3 负载均衡
### ribbon 
> 在服务消费端使用 eureka client 内部集成的 ribbon 实现负载均衡
- 注册中心集群: cloud-eureka-7071、cloud-eureka-7072
- 服务提供者：cloud-eureka-provider-8001、cloud-eureka-provider-8002
- 服务消费者：cloud-eureka-consumer-8081、cloud-eureka-consumer-8082

## 1.4 服务熔断降级
### 在服务端提供端实现
- 注册中心集群: cloud-eureka-7071、cloud-eureka-7072
- 服务提供者：cloud-eureka-provider-hystrix-8008
- 消费者：cloud-eureka-consumer-feign-8083
### 在服务消费端实现
- 注册中心集群: cloud-eureka-7071、cloud-eureka-7072
- 服务提供者：cloud-eureka-provider-hystrix-8008
- 消费者：cloud-eureka-consumer-feign-hystrix-8084
### 熔断器图像管理
- cloud-hystrix-dashboard-9000

## 1.5 配置中心、消息总线
### config + bus
> config：配置中心从 git 上远程获取配置文件，并将其同步到客户端\
> bus：使用消息总线 实现定点刷新、广播刷新
- 配置中心：cloud-eureka-config-3344
- 配置中心客户端：cloud-eureka-config-client-3355、cloud-eureka-config-client-3366

## 1.6 消息驱动： 以rabbitmq为例
### stream
> 消息驱动将消息队列的处理进行封装，直接使用消息驱动则可对不同消息中间件进行配置\
> 消息重复消费：通过分组（队列），避免同步消费
- 注册中心集群: cloud-eureka-7071、cloud-eureka-7072
- 生产者：cloud-eureka-stream-rabbitmq-provider-8880
- 消费者：cloud-eureka-stream-rabbitmq-consumer-8881、cloud-eureka-stream-rabbitmq-consumer-8882

## 1.7 分布式链路追踪
### sleuth
> 使用 zipkin 依赖 访问 9411
> 使用 cloud-eureka-consumer-8081、cloud-eureka-consumer-8082 \
> 调用 cloud-eureka-provider-8001、cloud-eureka-provider-8002 进行测试
- 注册中心集群: cloud-eureka-7071、cloud-eureka-7072
- 服务提供者：cloud-eureka-provider-8001、cloud-eureka-provider-8002
- 服务消费者：cloud-eureka-consumer-8081、cloud-eureka-consumer-8082

# 二、spring cloud alibaba 组件
## 2.1 注册中心 & 配置中心
### nacos
> nacos 内部集成了 ribbon，可直接实现负载均衡 
- 注册中心 & 配置中心: 本地搭建 nacos 集群
- 服务提供者：cloud-alibaba-nacos-provider-9001、cloud-alibaba-nacos-provider-9002
- 服务消费者：cloud-alibaba-nacos-consumer-9999
> 从 nacos 服务端远程获取配置文件
- 配置中心：本地 nacos 集群 
- 配置中心客户端：cloud-alibaba-nacos-config-client-3377

## 2.2 熔断器
### sentinel
> 通过 sentinel 服务端 dashboard 配置熔断限流规则进行熔断限流 \
> 持久化： 配置 nacos 远程配置文件，进行保存限流规则进行持久化
- 熔断器服务端： 本地启动 sentinel
- 熔断器客户端：cloud-alibaba-sentinel-service-8401
- 注册中心 & 配置中心: 本地搭建 nacos 集群

### sentinel + ribbon
> sentinel + ribbon 实现负载均衡、服务降级熔断限流
- 注册中心 & 配置中心: 本地搭建 nacos 集群
- 服务消费者：cloud-alibaba-sentinel-ribbon-consumer-8884
- 服务提供者：cloud-alibaba-nacos-provider-9001、cloud-alibaba-nacos-provider-9002

### sentinel + openfeign
> sentinel + openfeign 实现负载均衡、服务降级熔断限流
- 注册中心 & 配置中心: 本地搭建 nacos 集群
- 服务消费者：cloud-alibaba-sentinel-openfeign-consumer-8885
- 服务提供者：cloud-alibaba-nacos-provider-9001、cloud-alibaba-nacos-provider-9002

## 2.3 Docker 部署
### nacos-docker
>dokcer 中部署 nacos 的教程及相关材料

### sentinel-docker
> docker 中部署 sentinel 的 docker-compose