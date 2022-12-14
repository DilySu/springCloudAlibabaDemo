package com.dily.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * Date: 2022-11-04 星期五
 * Time: 10:15
 * Author: Dily_Su
 * Remark:
 */
@EnableEurekaClient  // 注册中心
@EnableCircuitBreaker // 开启熔断器
@SpringBootApplication
public class EurekaProviderHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderHystrixApplication.class, args);
    }

    /**
     * 此配置是为了服务监控而配置，与服务容错本身无关，springCloud升级后的坑
     * ServletRegistrationBean因为Springboot的默认路径不是“/hystrix.stream”
     * 只要在自己项目里配置下面的servlet 就可以了
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
