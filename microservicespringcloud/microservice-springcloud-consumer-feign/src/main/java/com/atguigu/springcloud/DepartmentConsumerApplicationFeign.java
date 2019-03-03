package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * DepartmentConsumerApplication class
 * @Author limingzhou 
 * @Date 2019/2/22
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.atguigu.springcloud"})
@ComponentScan("com.atguigu.springcloud")
public class DepartmentConsumerApplicationFeign {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentConsumerApplicationFeign.class,args);
    }
}
