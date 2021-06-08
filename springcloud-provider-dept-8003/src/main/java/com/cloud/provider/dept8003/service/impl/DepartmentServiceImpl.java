package com.cloud.provider.dept8003.service.impl;

import com.cloud.api.common.Response;
import com.cloud.api.pojo.Department;
import com.cloud.provider.dept8003.dao.DepartmentDao;
import com.cloud.provider.dept8003.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
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
