package com.cloud.consumer.dept80.controller;

import com.cloud.api.common.Response;
import com.cloud.api.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping(value = "consumer/dept")
@RestController
public class DepartmentController {
    // 消费者，不应该有service层
    // Restful  RestTemplate
    // url，实体：Map， Class<T> responseType
    @Autowired
    private RestTemplate restTemplate; // 提供多种便捷访问远程http服务的方法，简单的Restful服务模板

//    private static final String DEPT_REST_URL_PREFIX = "http://localhost:8001/";
    // Ribbon 这里设置的地址应该是一个变量，通过服务名来访问
    private static final String DEPT_REST_URL_PREFIX = "http://SPRING-CLOUD-PROVIDER-DEPT";


    @PostMapping
    public Response save(@RequestBody Department department) {
        String url = DEPT_REST_URL_PREFIX + "/dept";
        return restTemplate.postForObject(url, department, Response.class);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable(value = "id") Long id) {
        String url = DEPT_REST_URL_PREFIX + "/dept/" + id;
        return restTemplate.getForObject(url, Response.class);
    }

    @GetMapping
    public Response findAll() {
        String url = DEPT_REST_URL_PREFIX + "/dept";
        return restTemplate.getForObject(url, Response.class);
    }

}
