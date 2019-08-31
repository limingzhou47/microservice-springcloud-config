package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.Department;
import com.atguigu.springcloud.mapper.DepartmentMapper;
import com.atguigu.springcloud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DepartmentServiceImpl class
 * @Author limingzhou 
 * @Date 2019/2/1
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public boolean addDepartment(Department dept) {
        return departmentMapper.addDept(dept);
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentMapper.findById(id);
    }

    @Override
    public List<Department> listDepartment() {
        return departmentMapper.findAll();
    }
}
