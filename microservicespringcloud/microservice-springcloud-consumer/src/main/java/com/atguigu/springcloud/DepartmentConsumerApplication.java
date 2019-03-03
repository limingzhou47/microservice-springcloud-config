package com.atguigu.springcloud;

import com.atguigu.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * DepartmentConsumerApplication class
 * @Author limingzhou 
 * @Date 2019/2/22
 */
@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们自定义的Ribbon配置类,从而使配置生效
@RibbonClient(name = "MICROSERVICE-SPRINGCLOUD-PROVIDER",configuration = MySelfRule.class)
public class DepartmentConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentConsumerApplication.class,args);
    }
}
