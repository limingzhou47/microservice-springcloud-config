package com.atguigu.springcloud.service;/**
 * @Author limingzhou
 * @Date 2019/2/1-0:09
 */

import com.atguigu.springcloud.entities.Department;

import java.util.List;

/**
 * DepartmentService interface
 * @Author limingzhou
 * @Date 2019/2/1
 */
public interface DepartmentService {

    boolean addDepartment(Department dept);

    Department getDepartment(Long id);

    List<Department> listDepartment();
}
