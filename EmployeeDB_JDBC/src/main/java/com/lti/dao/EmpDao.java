package com.lti.dao;

import java.util.List;

import com.lti.beans.Employee;

public interface EmpDao {
	int addEmployee(Employee e);
	List<Employee> getEmpList();
	Employee searchById(int id);
	boolean updateEmpSalary(int id, double newSalary);
	boolean deleteEmp(int id);
}
