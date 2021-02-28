package com.cloud8002.controller;

import com.cloud.common.Response;
import com.cloud.pojo.Department;
import com.cloud8002.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    // 获取一些配置的信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    @PostMapping
    public Response addDepartment(Department department) {
        departmentService.save(department);
        return Response.success();
    }

    @GetMapping("{id}")
    public Response findById(@PathVariable("id") Long id) {
        return Response.success(departmentService.findById(id));
    }

    @GetMapping
    public Response findAll() {
        return Response.success(departmentService.findAll());
    }

    /**
     * 注册进来的微服务，获取一些信息
     */
    @GetMapping("/service")
    public Response discovery() {
        // 获取微服务列表的清单
        List<String> serviceList = client.getServices();
        System.out.println(" discovery => services: " + serviceList);

        // 得到一个具体的微服务信息，通过具体的微服务id，application.name
        List<ServiceInstance> instanceList = client.getInstances("spring-cloud-provider-dept");
        return Response.success(instanceList);
    }
}
