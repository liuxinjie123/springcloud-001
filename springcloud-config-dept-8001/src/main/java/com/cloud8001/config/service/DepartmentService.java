package com.cloud8001.config.service;

import com.cloud.pojo.Department;

import java.util.List;

public interface DepartmentService {

    public boolean save(Department department);

    public Department findById(Long id);

    public List<Department> findAll();

}
