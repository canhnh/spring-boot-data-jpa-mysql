package com.bezkoder.spring.datajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "dept_no")
	private String deptNo;
	@Column(name = "dept_name")
    private String deptName;
	
    public Department() {
 
    }    
    
    
    public long getId() {
		return id;
	}
    public Department(String deptNo, String deptName) {
        this.deptNo = deptNo;
        this.deptName = deptName;
       
    }
 
    public String getDeptNo() {
        return deptNo;
    }
 
    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }
 
    public String getDeptName() {
        return deptName;
    }
 
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
 
    
    @Override
	public String toString() {
		return "Employee [deptNo=" + deptNo + ", deptName=" + deptName + "]";
	}
}
