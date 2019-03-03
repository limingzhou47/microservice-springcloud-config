package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entities.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Department class
 * @Author limingzhou 
 * @Date 2019/1/31
 */
@Mapper
public interface DepartmentMapper {

    boolean addDept(Department dept);

    Department findById(Long id);

    List<Department> findAll();
}
