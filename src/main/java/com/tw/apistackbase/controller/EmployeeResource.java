package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import entity.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
    List<Employee> employees = new ArrayList<Employee>();
    @GetMapping(path="/")
    public ResponseEntity<List<Employee>> getAllEmployees() {
 
        employees.add(new Employee("张三", "001", 20));
        employees.add(new Employee("李四", "002", 20));
        return ResponseEntity.ok(employees);
    }
    
    
	@PostMapping(path="/")        //新增资源
	@ResponseStatus(HttpStatus.CREATED)
	public List<Employee> addEmployees(@RequestBody Employee employee){
		return employees;
	}
	@GetMapping(path="/{id}")      //查询
	public ResponseEntity<Employee> getOneEmployee(@PathVariable String id) {
		for (Employee employee:employees) {
			if (employee.getId().equals(id)) {
				return ResponseEntity.ok(employee);
			}
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")         //修改用户信息
    public ResponseEntity<List<Employee>> updateEmployee(@RequestBody Employee paramEmployeee){
        for(Employee employee : employees) {
            if (employee.getId().equals(paramEmployeee.getId())) {
                employee.setAge(paramEmployeee.getAge());
                employee.setName(paramEmployeee.getName());
                return ResponseEntity.ok(employees);
            }
        }
        return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
    }
	@DeleteMapping("/{id")     //删除信息
	public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
		 for(Employee employee : employees) {
			 if (employee.getId().equals(id)) {
				 employees.remove(employee);
				 return ResponseEntity.ok(null);
			 }
		 }
		 return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}
