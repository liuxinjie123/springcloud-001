package com.cloud.provider.dept8001.service.impl;

import com.cloud.api.common.Response;
import com.cloud.provider.dept8001.dao.DepartmentDao;
import com.cloud.provider.dept8001.service.DepartmentService;
import com.cloud.api.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Transactional
    public Response save(Department department) {
        int count = departmentDao.save(department);
        if (1 == count) {
            return Response.success(departmentDao.findById(department.getId()));
        } else {
            return Response.error();
        }
    }

    @Override
    public Response findById(Long id) {
        return Response.success(departmentDao.findById(id));
    }

    @Override
    public Response findAll() {
        return Response.success(departmentDao.findAll());
    }
}
