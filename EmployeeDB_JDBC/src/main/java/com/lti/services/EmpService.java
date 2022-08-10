package com.lti.services;

import java.util.List;

import com.lti.beans.Employee;

// menu card
public interface EmpService {
	int addEmployee(Employee e);
	List<Employee> getEmpList();
	Employee searchById(int id);
	boolean updateEmpSalary(int id, double newSalary);
	boolean deleteEmp(int id);
}
