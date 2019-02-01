package com.microservice.training.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by piyush.panda on 16/12/2018.
 */
@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitFromConf(){
        return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
    }
}
