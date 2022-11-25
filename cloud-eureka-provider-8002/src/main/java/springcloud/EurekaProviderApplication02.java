package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Date: 2022-10-27 星期四
 * Time: 13:22
 * Author: Dily_Su
 * Remark: 程序启动类
 */
@EnableDiscoveryClient // 服务发现
@EnableEurekaClient // 注册中心
@SpringBootApplication
public class EurekaProviderApplication02 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApplication02.class, args);
    }
}
