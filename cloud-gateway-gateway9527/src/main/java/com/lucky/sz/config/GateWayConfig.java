package com.lucky.sz.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @FileName: GateWayConfig.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-22
 **/
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu", r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        return routes.build();

    }

}
