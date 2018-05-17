package com.atguigu.ssm.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.ssm.beans.Department;
import com.atguigu.ssm.beans.Employee;
import com.atguigu.ssm.service.DepartmentService;
import com.atguigu.ssm.service.EmployeeService;

@Controller
public class EmployeeHandler {
	
	@Autowired
	private EmployeeService empService;
	@Autowired
	private DepartmentService deptService;
	
	
	/**
	 * 显示所有员工信息
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String getEmps(Model mod) {
		List<Employee> emps = empService.getAllEmps();
		mod.addAttribute("emps", emps);
		return "listEmps";
	}
	/**
	 * 去往添加员工页面
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/toAddEmp",method=RequestMethod.GET)
	public String toAddEmp(Model mod) {
		List<Department> depts = deptService.getDepts();
		Map<String,String> map = new HashMap<>();
		map.put("0", "女");
		map.put("1", "男");
		Employee employee = new Employee();
		
		mod.addAttribute("genders", map);
		mod.addAttribute("employee", employee);
		mod.addAttribute("depts", depts);
		return "input";
	}
	/**
	 * 添加操作
	 * @param emp
	 * @return
	 */
	@RequestMapping(value="/addEmp",method=RequestMethod.POST)
	public String addEmp(Employee emp) {
		empService.insertEmp(emp);
		return "redirect:/emps";
	}
	/**
	 * 
	 * 去修改页面
	 * @param id
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String toEditEmp(@PathVariable("id") int id,Model mod) {
		Map<String,String> map = new HashMap<>();
		map.put("0", "女");
		map.put("1", "男");
		Employee employee = empService.getEmpById(id);
		List<Department> depts = deptService.getDepts();
		mod.addAttribute("genders", map);
		mod.addAttribute("employee", employee);
		mod.addAttribute("depts", depts);
		
		return "input";
	}
	/**
	 * 修改操作
	 * @param emp
	 * @return
	 */
	@RequestMapping(value="/addEmp",method=RequestMethod.PUT)
	public String editEmp(Employee emp) {
		empService.updateEmp(emp);
		return "redirect:/emps";
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteEmp(@PathVariable("id") int id) {
		empService.delEmp(id);
		return "redirect:/emps";
	}
	


}
