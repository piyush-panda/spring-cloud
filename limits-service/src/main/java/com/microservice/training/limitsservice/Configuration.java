package com.microservice.training.limitsservice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by piyush.panda on 16/12/2018.
 */
@Component@ConfigurationProperties(prefix = "limits-service")
@Getter@Setter
public class Configuration {

    private int minimum;
    private int maximum;

}
