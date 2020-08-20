package com.bezkoder.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByEmpNoContaining(String empNo);
	List<Employee> findByEmpNameContaining(String empName);
	List<Employee> findByPositionContaining(String position);
}
