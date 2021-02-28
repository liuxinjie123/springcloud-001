package com.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // -- spring applicationContext.xml
public class ConfigBean {
    /**
     * 配置负载均衡
     */
    @Bean
    @LoadBalanced // Ribbon
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
