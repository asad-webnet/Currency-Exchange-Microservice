package com.asad.microservice.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    private Environment env;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to)
    {
        String port = env.getProperty("local.server.port");
        Optional<CurrencyExchange> ce = currencyExchangeRepository.findByFromAndTo(from,to);

        if(ce.isPresent()) {
            return ce.get();
        } else {
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }

    }
}
