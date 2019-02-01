package com.microservice.training.currencyconversionservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter@Setter@NoArgsConstructor
public class CurrencyConversionBean {

    private int id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal convertedValue;
    private int port;

}
