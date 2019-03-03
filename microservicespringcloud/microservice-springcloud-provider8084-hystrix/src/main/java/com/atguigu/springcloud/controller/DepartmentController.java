package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Department;
import com.atguigu.springcloud.service.DepartmentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Department dept) {
        return departmentService.add(dept);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    //@HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Department get(@PathVariable("id") Long id) {

        Department department = departmentService.get(id);
        if(null == department) {
            throw new RuntimeException("该ID：" + id + "没有对应的信息");
        }
        return department;
    }

   /* public Department processHystrix_Get(@PathVariable("id") Long id) {
        return new Department().setDeptId(id)
                .setDeptName("数据库中没有查到deptId为<" + id + ">对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                .setDbSource("no this database in MySQL");
    }*/

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Department> list() {
        return departmentService.list();
    }

    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
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
