package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.atguigu.springcloud.entities.Department;

import feign.hystrix.FallbackFactory;

@Component // 不要忘记添加，不要忘记添加
public class DepartmentClientServiceFallbackFactory implements FallbackFactory<DepartmentClientService> {

	@Override
	public DepartmentClientService create(Throwable throwable) {

		return new DepartmentClientService() {

			@Override
			public Department get(long id) {
				return new Department().setDeptId(id).setDeptName("数据库中没有查到deptId为<" + id + ">对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
						.setDbSource("no this database in MySQL");
			}

			@Override
			public List<Department> list() {
				return null;
			}

			@Override
			public boolean add(Department Department)
			{
				return false;
			}
		};
	}
}
