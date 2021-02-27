package com.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // -- spring applicationContext.xml
public class ConfigBean {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
