package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Department;
import com.atguigu.springcloud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * DepartmentController class
 * @Author limingzhou 
 * @Date 2019/2/1
 */
@RestController
@RequestMapping("/dept")
public class ProviderController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody Department dept) {
        return departmentService.addDepartment(dept);
    }

    @GetMapping(value = "/get/{id}")
    public Department get(@PathVariable("id") Long id) {
        return departmentService.getDepartment(id);
    }

    @GetMapping(value = "/list")
    public List<Department> list() {
        return departmentService.listDepartment();
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICE-SPRINGCLOUD-PROVIDER");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }

}
