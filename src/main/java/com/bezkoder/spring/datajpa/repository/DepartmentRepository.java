package com.bezkoder.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	List<Department> findByDeptNoContaining(String deptNo);
	List<Department> findByDeptNameContaining(String deptName);
	//List<Employee> findByPositionContaining(String position);
}
