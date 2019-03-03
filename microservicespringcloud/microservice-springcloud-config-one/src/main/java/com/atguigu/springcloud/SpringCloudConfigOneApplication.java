package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * SpringCloudConfigOneApplication class
 * @Author limingzhou 
 * @Date 2019/3/3
 */
@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigOneApplication.class, args);
    }

}
