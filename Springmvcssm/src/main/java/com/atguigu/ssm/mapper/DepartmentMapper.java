package com.atguigu.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.atguigu.ssm.beans.Department;

@Repository
public interface DepartmentMapper {
	
	public List<Department> getDepts();

}
