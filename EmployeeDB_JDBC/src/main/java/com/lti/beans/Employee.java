package com.lti.beans;

public class Employee {
	private int empId;
	private String empName;
	private double empSal;
	
	// constructor
	public Employee(int empId, String empName, double empSal) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
	}
	// default constructor
	public Employee() {
		super();
	}

	// getter and setter methods
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

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + empId + ", Name=" + empName + ", Salary=" + empSal + "]";
	}
	
	
}
