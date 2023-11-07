package com.asad.microservice.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/currency-conversion/**")
                        .filters(f ->
                                f.rewritePath("/currency-conversion/","/currency-conversion-feign/"))
                        .uri("lb://currency-conversion"))
                .build();
    }

}
