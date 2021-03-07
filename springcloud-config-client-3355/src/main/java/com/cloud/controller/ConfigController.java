package com.cloud.controller;

import com.cloud.common.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "config")
@RestController
public class ConfigController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String port;

    @GetMapping("info")
    public Response getApplicationName() {
        String data = "applicationName: " + applicationName
                + ", eureka server: " + eurekaServer
                + ", server port: " + port;
        return Response.success(data);
    }


}
