package com.cloud.consumer.dept.feign.service;

import com.cloud.api.common.Response;
import com.cloud.api.pojo.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "SPRING-CLOUD-PROVIDER-DEPT")
//@FeignClient(value = "SPRING-CLOUD-PROVIDER-DEPT", fallbackFactory = DepartClientServiceFallbackFactory.class)
public interface DepartClientService {

    @PostMapping(value = "/dept")
    Response save(@RequestBody Department department);

    @GetMapping(value = "/dept/{id}")
    Response findById(@PathVariable("id") Long id);

    @GetMapping(value = "/dept")
    Response findAll();

}
