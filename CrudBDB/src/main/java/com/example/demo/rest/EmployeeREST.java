package com.example.demo.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeREST {
	
	 @Autowired
	 private EmployeeService employeeService;
	 
	 @GetMapping
	 private ResponseEntity<List<Employee>> getAllEmployees(){
		 return ResponseEntity.ok(employeeService.findAll());
	 }
	 
	 @PostMapping
	 private ResponseEntity<Employee> saveEmployee (@RequestBody Employee employee){
		 try {
			 Employee employeeSave = employeeService.save(employee);
			 return ResponseEntity.created(new URI("/employee/"+employeeSave.getIdEmp())).body(employeeSave);
		 }catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		 }
		
	 }
	 @DeleteMapping (value = "/delete/{id}")
	 private ResponseEntity<Boolean> deleteEmployee (@PathVariable ("id") Long id){
		 employeeService.deleteById(id);
		 return ResponseEntity.ok(!(employeeService.findById(id)!=null));
	 }
	
}
