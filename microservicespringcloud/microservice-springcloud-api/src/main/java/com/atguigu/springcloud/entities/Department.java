package com.atguigu.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Department class
 * @Author limingzhou 
 * @Date 2019/1/31
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Department implements Serializable{

    private static final long serialVersionUID = 4238351104378294325L;

    private Long deptId;    //主键

    private String deptName;   //部门名称

    private String dbSource;   //微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Department(String deptName) {
        this.deptName = deptName;
    }

}
