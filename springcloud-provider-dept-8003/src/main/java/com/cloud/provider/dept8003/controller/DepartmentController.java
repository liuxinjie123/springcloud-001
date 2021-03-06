package com.cloud.provider.dept8003.controller;

import com.cloud.api.common.Response;
import com.cloud.api.pojo.Department;
import com.cloud.provider.dept8003.service.DepartmentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    public Response addDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @GetMapping("{id}")
    @HystrixCommand(fallbackMethod = "findByIdHystrix")
    public Response findById(@PathVariable("id") Long id) {
        return departmentService.findById(id);
    }

    @GetMapping
    public Response findAll() {
        return departmentService.findAll();
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

    /**
     * 备选方案
     */
    public Response findByIdHystrix(@PathVariable("id") Long id) {
        return Response.success(new Department().setId(id).setName("id=>" + id + ", 不存在该用户！ @Hystrix"));
    }
}
