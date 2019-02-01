package com.microservice.training.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/currency-converter/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversionBean convert(@PathVariable String fromCurrency, @PathVariable String toCurrency, @PathVariable BigDecimal quantity){

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", fromCurrency);
        uriVariables.put("to", toCurrency);
        ResponseEntity<CurrencyConversionBean> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);

        CurrencyConversionBean currencyConversionBean = forEntity.getBody();
        currencyConversionBean.setQuantity(quantity);
        currencyConversionBean.setConvertedValue(quantity.multiply(currencyConversionBean.getConversionMultiple()));
        return currencyConversionBean;

    }

    @GetMapping("/currency-converter-feign/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversionBean convertFeign(@PathVariable String fromCurrency, @PathVariable String toCurrency, @PathVariable BigDecimal quantity){

        CurrencyConversionBean exchange = proxy.exchange(fromCurrency, toCurrency);
        exchange.setQuantity(quantity);
        exchange.setConvertedValue(quantity.multiply(exchange.getConversionMultiple()));
        return exchange;

    }
}
