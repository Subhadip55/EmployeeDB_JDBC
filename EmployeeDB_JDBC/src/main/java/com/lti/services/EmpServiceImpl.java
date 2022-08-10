package com.lti.services;

import java.util.List;

import com.lti.beans.Employee;
import com.lti.dao.EmpDao;
import com.lti.dao.EmpDaoImpl;

// waiter
public class EmpServiceImpl implements EmpService {
	EmpDao dao = new EmpDaoImpl();

	public int addEmployee(Employee e) {
		return dao.addEmployee(e);
	}

	public List<Employee> getEmpList() {
		return dao.getEmpList();
	}

	public Employee searchById(int id) {
		return dao.searchById(id);
	}

	public boolean updateEmpSalary(int id, double newSalary) {
		return dao.updateEmpSalary(id, newSalary);
	}

	public boolean deleteEmp(int id) {
		return dao.deleteEmp(id);
	}
}
