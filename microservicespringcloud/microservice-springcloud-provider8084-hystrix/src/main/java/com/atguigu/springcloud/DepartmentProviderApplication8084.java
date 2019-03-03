package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
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
@EnableCircuitBreaker       //对Hystrix熔断机制的支持
public class DepartmentProviderApplication8084 {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentProviderApplication8084.class,args);
    }
}
