package com.cloud.provider.dept8002.service.impl;

import com.cloud.api.common.Response;
import com.cloud.provider.dept8002.dao.DepartmentDao;
import com.cloud.api.pojo.Department;
import com.cloud.provider.dept8002.service.DepartmentService;
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
            return Response.success(department);
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
