package com.atguigu.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MySelfRule class
 * @Author limingzhou 
 * @Date 2019/2/24
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        //return new RandomRule();    //默认为轮询,自定义为随机
        return new RandomRule_LMZ();    //默认为轮询
    }
}
