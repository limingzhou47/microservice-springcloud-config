package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * DepartmentProviderApplication class
 * @Author limingzhou 
 * @Date 2019/2/1
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient      //服务发现
public class ProviderApplication8082 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication8082.class,args);
    }
}
