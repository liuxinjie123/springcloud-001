package com.cloud.provider.dept8003.service.impl;

import com.cloud.api.pojo.Department;
import com.cloud.provider.dept8003.dao.DepartmentDao;
import com.cloud.provider.dept8003.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Department findById(Long id) {
        return departmentDao.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
