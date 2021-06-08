package com.cloud.provider.dept8002.service;

import com.cloud.api.common.Response;
import com.cloud.api.pojo.Department;

public interface DepartmentService {

    public Response save(Department department);

    public Response findById(Long id);

    public Response findAll();

}
