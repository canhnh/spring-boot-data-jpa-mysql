package com.bezkoder.spring.datajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "emp_no")
	private String empNo;
	@Column(name = "emp_name")
    private String empName;
	@Column(name = "position")
    private String position;
	@Column(name = "dept")
    private long dept;
 
    public Employee() {
 
    }
 
    public long getId() {
		return id;
	}
    
    public Employee(String empNo, String empName, String position,long dept) {
        this.empNo = empNo;
        this.empName = empName;
        this.position = position;
        this.dept= dept;
    }
 
    public String getEmpNo() {
        return empNo;
    }
 
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
 
    public String getEmpName() {
        return empName;
    }
 
    public void setEmpName(String empName) {
        this.empName = empName;
    }
 
    public String getPosition() {
        return position;
    }
 
    public void setPosition(String position) {
        this.position = position;
    }
    
    public long getDept() {
        return dept;
    }
 
    public void setDept(long dept) {
        this.dept = dept;
    }
    
    @Override
	public String toString() {
		return "Employee [id=" + id + ", empNo=" + empNo + ", empName=" + empName + ", position=" + position + "]";
	}
}
