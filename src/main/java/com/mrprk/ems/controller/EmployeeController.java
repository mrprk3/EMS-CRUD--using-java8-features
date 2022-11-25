package com.mrprk.ems.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrprk.ems.entity.Employee;
import com.mrprk.ems.service.EmployeeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeeService employeeeService;

	@PostMapping("/save")
	public String saveEmployee(@RequestBody Employee employee) {
		employeeeService.save(employee);
		return "Registration successfull";
	}
	// Lets fetch all the employees
	@GetMapping("/get")
	public List<Employee> getEmpList() {
		return employeeeService.getEmpList();
	}

	// Lets fetch employees list based on first letter
	@GetMapping("/get/{letter}")
	public List<Employee> getEmployeeList(@PathVariable String letter) {
		List<Employee> res = employeeeService.getEmpList();
		List<Employee> finalRes = res.stream().filter((i) -> i.getName().startsWith(letter))
				.collect(Collectors.toList());
		return finalRes;
	}

	// Lets fetch taxable employee those who's salary above .... per month
	@GetMapping("/get/taxable/{salary}")
	public List<Employee> getTaxableEmp(@PathVariable int salary) {
		List<Employee> res = employeeeService.getEmpList();
		return res.stream().filter((i) -> i.getSalary() > salary).collect(Collectors.toList());
	}

	// Lets fetch employees based on salary (sorting order)
	@GetMapping("/get/emp/salary")
	public List<Employee> getEmpBasedOnSal() {
		List<Employee> res = employeeeService.getEmpList();
		return res.stream().sorted((o1, o2) -> o1.getSalary() - o2.getSalary()).collect(Collectors.toList());
	}

	// Lets fetch employees based on employee name (sorting order)
	@GetMapping("/get/emp/name")
	public List<Employee> getEmpBasedOnName() {
		List<Employee> res = employeeeService.getEmpList();
		return res.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
	}

	// Lets find the record based on name
	@GetMapping("/get/emp/name/{name}")
	public List<Employee> getEmpByName(@PathVariable String name) {
		List<Employee> res = employeeeService.getEmpList();
		return res.stream().filter((i) -> i.getName().equals(name)).collect(Collectors.toList());
	}

}
