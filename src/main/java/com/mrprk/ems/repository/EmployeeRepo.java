package com.mrprk.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrprk.ems.entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
