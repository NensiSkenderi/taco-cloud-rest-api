package com.taco.cloud.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeansConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
