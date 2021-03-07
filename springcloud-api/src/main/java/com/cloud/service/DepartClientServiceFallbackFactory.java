package com.cloud.service;

import com.cloud.pojo.Department;
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
            public boolean save(Department department) {
                return false;
            }

            @Override
            public Department findById(Long id) {
                return new Department()
                        .setId(id)
                        .setName("id=>" + id + ", 没有对应的信息，客户端提供了降级信息，这个服务现在已被关闭。！ @Hystrix");
            }

            @Override
            public List<Department> findAll() {
                return null;
            }
        };
    }
}
