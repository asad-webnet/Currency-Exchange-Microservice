package com.asad.microservice.currencyexchangeservice;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBreakerController {

    @GetMapping("/sample-api")
    @Retry(name = "default",fallbackMethod = "hardcodedResponse")
    @RateLimiter(name = "default")
    // 10 seconds, allow 2 requests only
    public String sampleApi() {

        log.info("Sample API Call received");

        return "sample-api";
    }

    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }
}
