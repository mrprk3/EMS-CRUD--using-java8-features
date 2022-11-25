package com.mrprk.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrprk.ems.entity.Employee;
import com.mrprk.ems.repository.EmployeeRepo;

@Service
public class EmployeeeService {
	@Autowired
	EmployeeRepo employeeRepo;

	public void save(Employee employee) {
		employeeRepo.save(employee);
	}

	public List<Employee> getEmpList() {
		return employeeRepo.findAll();
	}

}
