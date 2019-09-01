package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ConfigBean class
 * @Author limingzhou 
 * @Date 2019/2/22
 */
@Configuration
public class ConfigBean {

    @Bean
    //@LoadBalanced   //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

   /* @Bean
    public IRule myRule() {
        //return new RandomRule();    //达到的目的,用我们指定的随机算法替代默认的轮询
        return new RetryRule();
    }*/
}

//@Bean
//public UserService getUserService() {
//    return new UserServiceImpl();
//}
////applicationContext.xml == ConfigBean(@Configuration)
//<bean id="userService" class="com.atguigu.springcloud.UserServiceImpl"/>