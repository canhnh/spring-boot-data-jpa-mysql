package com.bezkoder.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.model.Department;
import com.bezkoder.spring.datajpa.model.Employee;
import com.bezkoder.spring.datajpa.repository.DepartmentRepository;
import com.bezkoder.spring.datajpa.repository.EmployeeRepository;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class DepartmentController {
	@Autowired
	DepartmentRepository deptRepository;

	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getAllDepartments(@RequestParam(required = false) String name) {
		try {
			List<Department> depts = new ArrayList<Department>();

			if (name == null)
				deptRepository.findAll().forEach(depts::add);
			else
				deptRepository.findByDeptNameContaining(name).forEach(depts::add);

			if (depts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(depts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("/departments/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long id) {
		Optional<Department> deptData = deptRepository.findById(id);

		if (deptData.isPresent()) {
			return new ResponseEntity<>(deptData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin(origins = "http://localhost:8081")
	@PostMapping("/departments")
	public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
		try {
			Department dept= new Department(department.getDeptNo(), department.getDeptName());
			Department _dept = deptRepository.save(dept);
			return new ResponseEntity<>(_dept, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@CrossOrigin(origins = "http://localhost:8081")
	@PutMapping("/departments/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") long id, @RequestBody Department dept) {
		Optional<Department> deptData = deptRepository.findById(id);

		if (deptData.isPresent()) {
			Department _dept = deptData.get();
			_dept.setDeptNo(dept.getDeptNo());
			_dept.setDeptName(dept.getDeptName());
			//_employee.setPosition(employee.getPosition());
			return new ResponseEntity<>(deptRepository.save(_dept), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin(origins = "http://localhost:8081")
	@DeleteMapping("/departments/{id}")
	public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") long id) {
		try {
			deptRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@CrossOrigin(origins = "http://localhost:8081")
	@DeleteMapping("/departments")
	public ResponseEntity<HttpStatus> deleteAllDepartments() {
		try {
			deptRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

//	@GetMapping("/employees/position/{pos}")
//	public ResponseEntity<List<Employee>> findByPosition(@RequestParam(required = false) String position) {
//		try {
//			List<Employee> employees = employeeRepository.findByPosition(position);
//
//			if (employees.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			return new ResponseEntity<>(employees, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
//		}
//	}

}
