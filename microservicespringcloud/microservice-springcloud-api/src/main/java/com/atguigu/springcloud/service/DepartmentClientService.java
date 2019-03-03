package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Department;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * DepartmentClientService interface
 *
 * 修改microservicecloud-api工程，根据已经有的DeptClientService接口
 * 新建一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
 * @Author limingzhou
 * @Date 2019/2/24
 */
//@FeignClient(value = "MICROSERVICE-SPRINGCLOUD-PROVIDER")
@FeignClient(value = "MICROSERVICE-SPRINGCLOUD-PROVIDER", fallbackFactory = DepartmentClientServiceFallbackFactory.class)
public interface DepartmentClientService {

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Department get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Department> list();

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(Department dept);
}
