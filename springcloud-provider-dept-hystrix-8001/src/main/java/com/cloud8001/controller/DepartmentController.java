package com.cloud8001.controller;

import com.cloud.pojo.Department;
import com.cloud8001.service.DepartmentService;
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

    @GetMapping("{id}")
    @HystrixCommand(fallbackMethod = "findByIdHystrix")
    public Department findById(@PathVariable("id") Long id) {
        Department department = departmentService.findById(id);
        if (null == department) {
            throw new RuntimeException("id=>" + id + ", 不存在该用户！");
        }
        return department;
    }

    /**
     * 备选方案
     */
    public Department findByIdHystrix(@PathVariable("id") Long id) {
        return new Department().setId(id).setName("id=>" + id + ", 不存在该用户！ @Hystrix");
    }

}
