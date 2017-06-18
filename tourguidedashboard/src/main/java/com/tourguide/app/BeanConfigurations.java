package com.tourguide.app;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by manjtsingh on 6/17/2017.
 */
@Component
public class BeanConfigurations {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
