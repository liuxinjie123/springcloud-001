package com.cloud8001;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * 服务启动后，自动注册到 Eureka中
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient      //服务发现
@EnableCircuitBreaker       //添加对熔断的支持
public class ProviderHystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrix8001.class, args);
    }

    /**
     * 增加一个 servlet
     */
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}
