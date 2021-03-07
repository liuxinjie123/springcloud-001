package com.cloud.hystrix;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard     // 开启监控页面
public class ConsumerDashboard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerDashboard_9001.class, args);
    }


}
