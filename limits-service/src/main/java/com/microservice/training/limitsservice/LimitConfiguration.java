package com.microservice.training.limitsservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by piyush.panda on 16/12/2018.
 */
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class LimitConfiguration {

    private int minimum;
    private int maximum;
}
