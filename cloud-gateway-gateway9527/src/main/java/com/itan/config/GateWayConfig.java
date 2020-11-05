package com.itan.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/3 23:50
 */
@Configuration
public class GateWayConfig {
    /**
     * 自定义路由
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        /**
         * route有两个参数，第一个表示路由id（自定义，不能重复），第二个是函数式接口
         * r.path("匹配到的地址").uri("相匹配后要转到的地址")
         */
        routes.route("route1",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
