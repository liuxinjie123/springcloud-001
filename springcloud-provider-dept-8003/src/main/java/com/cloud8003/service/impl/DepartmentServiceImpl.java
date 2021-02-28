package com.cloud8003.service.impl;

import com.cloud.pojo.Department;
import com.cloud8003.dao.DepartmentDao;
import org.springframework.stereotype.Service;
import com.cloud8003.service.DepartmentService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
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
