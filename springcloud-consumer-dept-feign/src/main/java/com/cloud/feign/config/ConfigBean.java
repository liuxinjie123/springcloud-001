package com.cloud.feign.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // -- spring applicationContext.xml
public class ConfigBean {
    /**
     * 配置负载均衡
     * IRule
     *
     * RandomRule   ：随机
     * RoundRobinRule   ： 轮询
     * AvailabilityFilteringRule : 会先过滤掉 跳闸、访问故障 的服务，对剩下的进行轮询。
     * WeightedResponseTimeRule ： 权重
     * RetryRule    ： 会先按轮询获取服务，如果服务获取失败，则会在指定的时间内进行重试。
     */
    @Bean
    @LoadBalanced // Ribbon
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public IRule myRule() {
//        return new RandomRule();
//    }

}
