package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	List<Employee> employees=new ArrayList<>();
	@PostMapping
	public void addEmployee(@RequestBody Employee employee) {
		employees.add(employee);
		System.out.print(employees);
	}
	
//	@GetMapping       //查询所有员工信息
//	public List<Employee> getEmployee(){
//		return employees;
//	}
	@GetMapping       //搜索员工信息
	public List<Employee> getEmployee(@RequestParam(value="nameLike",required=false) String nameLike){
		List<Employee> nameLikeEmployeeList=new ArrayList<>();
		if(nameLike != null) {
			for(Employee employee:employees) {
				if(employee.getName().contains(nameLike)) {
					nameLikeEmployeeList.add(employee);
				}
			}
			return nameLikeEmployeeList;
		}else {
			return employees;
		}
		
	}
	
	@GetMapping ("/{employId}")      //查询某个员工信息
	public Employee getOneEmployee(@PathVariable String employId){
		for(Employee employee:employees ) {
			if(employee.getId().equals(employId)) {
				return employee;
			}
		}
		return null;
	}
	
	@PutMapping("/{employeeId}")
	public void updateEmployee(@PathVariable String employeeId,@RequestBody Employee newemployee) {
		for(Employee employee:employees ) {
			if(employee.getId().equals(employeeId)) {
				employee.setName(newemployee.getName());
				employee.setAge(newemployee.getAge());
			}
		}
	}
	
	@DeleteMapping("/{employeeId}")
	public void deleteEmployee(@PathVariable String employeeId) {
		for(Employee employee:employees ) {
			if(employee.getId().equals(employeeId)) {
				employees.remove(employee);
			}
		}
	}
	
	

}
