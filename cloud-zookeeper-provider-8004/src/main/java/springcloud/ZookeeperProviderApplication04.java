package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Date: 2022-10-27 星期四
 * Time: 13:22
 * Author: Dily_Su
 * Remark: 程序启动类
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ZookeeperProviderApplication04 {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperProviderApplication04.class, args);
    }
}
