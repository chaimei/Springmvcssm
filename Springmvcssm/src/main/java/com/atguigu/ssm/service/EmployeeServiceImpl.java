package com.atguigu.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.ssm.beans.Employee;
import com.atguigu.ssm.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeMapper empMapper;

	@Override
	public List<Employee> getAllEmps() {
		List<Employee> emps = empMapper.getEmps();
		return emps;
	}

	@Transactional
	public void insertEmp(Employee emp) {
		empMapper.insertEmp(emp);
	}

	@Override
	public void delEmp(int id) {
		empMapper.delEmp(id);
		
	}

	@Override
	public Employee getEmpById(int id) {
		Employee emp = empMapper.getEmpById(id);
		return emp;
	}

	@Transactional
	public void updateEmp(Employee emp) {
		empMapper.updateEmp(emp);
		
	}

}
