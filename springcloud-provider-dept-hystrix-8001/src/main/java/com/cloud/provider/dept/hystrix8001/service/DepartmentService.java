package com.cloud.provider.dept.hystrix8001.service;

import com.cloud.api.pojo.Department;

import java.util.List;

public interface DepartmentService {

    public boolean save(Department department);

    public Department findById(Long id);

    public List<Department> findAll();

}
