package com.dily.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Date: 2022-11-10 星期四
 * Time: 15:23
 * Author: Dily_Su
 * Remark: 编码方法实现（不推荐），推荐使用配置文件方式
 */
@Configuration
public class ApiConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routers = routeLocatorBuilder.routes();
        // 将 /guonei 转发到 http://news.baidu.com/guonei
        routers.route("route_dily_1", r ->
                r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        // 将 /game 转发到 http://news.baidu.com/guonei
        routers.route("route_dily_2", r ->
                r.path("/game").uri("http://news.baidu.com/game")).build();
        return routers.build();
    }
}
