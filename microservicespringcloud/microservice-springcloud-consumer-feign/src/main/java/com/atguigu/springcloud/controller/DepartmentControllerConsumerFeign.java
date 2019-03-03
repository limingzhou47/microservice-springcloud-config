package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Department;
import com.atguigu.springcloud.service.DepartmentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * DepartmentController class
 * @Author limingzhou 
 * @Date 2019/2/22
 */
@RestController
public class DepartmentControllerConsumerFeign {

    @Autowired
    private DepartmentClientService departmentClientService;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Department get(@PathVariable("id") Long id) {
        return this.departmentClientService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Department> list() {
        return this.departmentClientService.list();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Department department) {
        return this.departmentClientService.add(department);
    }

}
