package com.cloud.provider.dept.hystrix8001.controller;

import com.cloud.api.common.Response;
import com.cloud.api.pojo.Department;
import com.cloud.provider.dept.hystrix8001.service.DepartmentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("{id}")
    @HystrixCommand(fallbackMethod = "findByIdHystrix")
    public Response findById(@PathVariable("id") Long id) {
        Department department = departmentService.findById(id);
        if (null == department) {
            throw new RuntimeException("id=>" + id + ", 不存在该用户！");
        }
        return Response.success(department);
    }

    /**
     * 备选方案
     */
    public Response findByIdHystrix(@PathVariable("id") Long id) {
        return Response.success(new Department().setId(id).setName("id=>" + id + ", 不存在该用户！ @Hystrix"));
    }

}
