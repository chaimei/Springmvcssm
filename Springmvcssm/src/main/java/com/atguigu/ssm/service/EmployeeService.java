package com.atguigu.ssm.service;

import java.util.List;

import com.atguigu.ssm.beans.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmps();
	
	public void insertEmp(Employee emp);
	
	public void delEmp( int id);
	
	public Employee getEmpById(int id);
	
	public void updateEmp(Employee emp);

}
