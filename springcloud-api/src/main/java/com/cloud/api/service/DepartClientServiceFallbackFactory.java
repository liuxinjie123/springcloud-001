package com.cloud.api.service;

import com.cloud.api.common.Response;
import com.cloud.api.pojo.Department;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 降级
 */
@Component
public class DepartClientServiceFallbackFactory implements FallbackFactory {

    @Override
    public DepartClientService create(Throwable throwable) {
        return new DepartClientService() {
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
        };
    }
}
