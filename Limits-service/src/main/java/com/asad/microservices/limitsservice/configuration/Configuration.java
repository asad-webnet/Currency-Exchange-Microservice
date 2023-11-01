package com.asad.microservices.limitsservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("limits-service")
@Getter
@Setter
@Component
public class Configuration {

    private int minimum;
    private int maximum;
}
