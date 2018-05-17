package com.atguigu.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.atguigu.ssm.beans.Employee;

@Repository
public interface EmployeeMapper {
	
	public List<Employee> getEmps();
	
	public void insertEmp(Employee emp);
	
	public void delEmp(int id);
	
	public Employee getEmpById(int id);
	
	public void updateEmp(Employee emp);

}
