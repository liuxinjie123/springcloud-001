package com.cloud.provider.dept8002.service.impl;

import com.cloud.provider.dept8002.dao.DepartmentDao;
import com.cloud.api.pojo.Department;
import com.cloud.provider.dept8002.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public boolean save(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public Department findById(Long id) {
        return departmentDao.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
