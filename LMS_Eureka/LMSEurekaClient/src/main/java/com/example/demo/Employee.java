package com.example.demo;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int empId;
	private String empName;
	private String empMail;
	private String empMobNo;
	private Date empDtJoin;
	private String empDept;
	private int empManagerId;
	private int empAvailLeaveBal;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public String getEmpMail() {
		return empMail;
	}
	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}
	public String getEmpMobNo() {
		return empMobNo;
	}
	public void setEmpMobNo(String empMobNo) {
		this.empMobNo = empMobNo;
	}
	public Date getEmpDtJoin() {
		return empDtJoin;
	}
	public void setEmpDtJoin(Date empDtJoin) {
		this.empDtJoin = empDtJoin;
	}
	public int getEmpManagerId() {
		return empManagerId;
	}
	public void setEmpManagerId(int empManagerId) {
		this.empManagerId = empManagerId;
	}
	public int getEmpAvailLeaveBal() {
		return empAvailLeaveBal;
	}
	public void setEmpAvailLeaveBal(int empAvailLeaveBal) {
		this.empAvailLeaveBal = empAvailLeaveBal;
	}
	
	
	
}
