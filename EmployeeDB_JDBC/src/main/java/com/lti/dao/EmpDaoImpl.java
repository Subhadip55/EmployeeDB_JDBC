package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lti.beans.Employee;

public class EmpDaoImpl implements EmpDao {

	Connection conn = null;

	public int addEmployee(Employee e) {

		// add it in database
		// dont put here syso msg
		// call the service and service will let user know

		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver"); // we don't need it
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "subha_lti", "subha");

			String sql = "insert into EmpJdbc values(?,?,?)";
			PreparedStatement prst = conn.prepareStatement(sql);

			prst.setInt(1, e.getEmpId());
			prst.setString(2, e.getEmpName());
			prst.setDouble(3, e.getEmpSal());

			int records = prst.executeUpdate();
			System.out.println(records + " record added");

			prst.close();
			conn.close();
		} /*
			 * catch (ClassNotFoundException e1) { e1.printStackTrace(); }
			 */catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e.getEmpId();
	}

	public List<Employee> getEmpList() {
		List<Employee> empList = new ArrayList<Employee>();
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "subha_lti", "subha");

			String sql = "select * from EmpJdbc";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				empList.add(e);
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}

	public Employee searchById(int id) {
		
		String sql = "select * from EmpJdbc where empNo = "+id;
		Employee e = null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "subha_lti", "subha");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				e = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3));
			}
			stmt.close();
			conn.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return e;
	}

	public boolean updateEmpSalary(int id, double newSalary) {
		String sql = "update EmpJdbc set empSal=? where empNo = ?";
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "subha_lti", "subha");
			PreparedStatement prst = conn.prepareStatement(sql);
			prst.setDouble(1, newSalary);
			prst.setInt(2, id);
			
			if(prst.executeUpdate()!=0) {
				prst.close();
				conn.close();
				return true;
			}
			else {
				prst.close();
				conn.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteEmp(int id) {
		String sql = "delete from EmpJdbc where empNo = ?";
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "subha_lti", "subha");
			PreparedStatement prst = conn.prepareStatement(sql);
			prst.setInt(1, id);
			
			if(prst.executeUpdate()!=0) {
				prst.close();
				conn.close();
				return true;
			}
			else {
				prst.close();
				conn.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
