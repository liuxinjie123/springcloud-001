package com.cloud.controller;

import com.cloud.common.Response;
import com.cloud.pojo.Department;
import com.cloud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Response addDepartment(@RequestBody Department department) {
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
}
