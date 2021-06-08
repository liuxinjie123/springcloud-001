package com.cloud.consumer.dept.feign.controller;

import com.cloud.api.common.Response;
import com.cloud.api.pojo.Department;
import com.cloud.api.service.DepartClientService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping(value = "consumer/dept")
@RestController
public class DepartmentController {
    // 消费者，不应该有service层
    // Restful  RestTemplate
    // url，实体：Map， Class<T> responseType
    @Resource
    private DepartClientService departService;


    @PostMapping
    public Response save(@RequestBody Department department) {
        return Response.success(this.departService.save(department));
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable(value = "id") Long id) {
        return Response.success(this.departService.findById(id));
    }

    @GetMapping
    public Response findAll() {
        return Response.success(this.departService.findAll());
    }

}
