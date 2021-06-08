package com.cloud.consumer.dept.feign.service;

import com.cloud.api.common.Response;
import com.cloud.api.pojo.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartClientServiceHystrix implements DepartClientService{
    @Override
    public Response save(Department department) {
        return Response.error();
    }

    @Override
    public Response findById(Long id) {
        return Response.success(new Department()
                .setId(id)
                .setName("id=>" + id + ", 没有对应的信息，客户端提供了降级信息，这个服务现在已被关闭。！ @Hystrix"));
    }

    @Override
    public Response findAll() {
        return Response.success();
    }
}
