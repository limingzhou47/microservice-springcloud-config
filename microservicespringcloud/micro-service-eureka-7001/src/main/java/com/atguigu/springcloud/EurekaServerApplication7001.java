package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaServerApplication class
 * @Author limingzhou 
 * @Date 2019/2/22
 */

@SpringBootApplication
@EnableEurekaServer     //EurekaServer服务器端启动类,接受其它微服务注册进来
public class EurekaServerApplication7001 {

    public static void main(String[] args) {

        SpringApplication.run(EurekaServerApplication7001.class, args);
    }

}
