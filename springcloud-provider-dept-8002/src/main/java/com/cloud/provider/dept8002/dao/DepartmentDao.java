package com.cloud.provider.dept8002.dao;

import com.cloud.api.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentDao {

    public int save(Department department);

    public Department findById(Long id);

    public List<Department> findAll();

}
