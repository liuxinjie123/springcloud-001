package com.cloud.service;

import com.cloud.pojo.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRING-CLOUD-PROVIDER-DEPT")
public interface DepartClientService {

    @PostMapping(value = "/dept")
    public boolean save(Department department);

    @GetMapping(value = "/dept/{id}")
    public Department findById(@PathVariable("id") Long id);

    @GetMapping(value = "/dept")
    public List<Department> findAll();

}
