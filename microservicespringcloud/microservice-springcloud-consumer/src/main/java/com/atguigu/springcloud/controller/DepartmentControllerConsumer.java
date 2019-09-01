package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * DepartmentController class
 * @Author limingzhou 
 * @Date 2019/2/22
 */
@RestController
public class DepartmentControllerConsumer {

    private static final String REST_URL_PREFIX = "http://localhost:8081";

    //private static final String REST_URL_PREFIX = "http://MICROSERVICE-SPRINGCLOUD-PROVIDER";

    /**
     * 使用RestTemplate访问restful接口
     * (url、requestMap、ResponseBean.class)分别代表REST请求地址、请求参数、HTTP响应转换
     * */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Department department) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", department, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Department get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Department.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Department> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {

        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
}
