package com.lti.user;

import java.util.List;
import java.util.Scanner;

import com.lti.beans.Employee;
import com.lti.services.EmpService;
import com.lti.services.EmpServiceImpl;

public class UserApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		EmpService service = new EmpServiceImpl();
		
		System.out.println("---Welcome to the Employee Database Application---"+
							"\n\n1. Add a new employee"+
							"\n2. View all employee details"+
							"\n3. Search employee by his/her id"+
							"\n4. Update employee salary"+
							"\n5. Delete an employee details"
							);
		
		System.out.print("\nEnter your choice : ");
		int choice = sc.nextInt();
		System.out.println();	// just for extra line
		
		switch(choice) {
		case 1: 
			System.out.print("Put the following details\nEnter Employee Id : ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Employee Name : ");
			String name = sc.nextLine();
			System.out.print("Enter Employee Salary : ");
			double sal = sc.nextDouble();
			
			Employee e1 = new Employee(id, name, sal);
			int empId = service.addEmployee(e1);
			
			System.out.println("\nYou are registered with ID "+empId);
			
			break;
		case 2:
			List<Employee> empList = service.getEmpList();
			for(int i=0;i<empList.size();i++) {
				System.out.println(empList.get(i));
			}
			break;
		case 3:
			System.out.print("Enter Employee Id : ");
			int id1 = sc.nextInt();
			Employee e = service.searchById(id1);
			
			System.out.println("\n"+e);
			break;
		case 4:
			System.out.print("Enter Employee Id : ");
			int id2 = sc.nextInt();
			System.out.print("Enter new salary : ");
			double newSalary = sc.nextDouble();
			if(service.updateEmpSalary(id2, newSalary)) {
				System.out.println("\nCongrats! Salary updated successfully");
			}
			else {
				System.out.println("\nID ("+id2+") does not exist");
			}
			break;
		case 5:
			System.out.print("Enter Employee Id : ");
			int id3 = sc.nextInt();
			if(service.deleteEmp(id3)) {
				System.out.println("\nEmployee with Id "+id3+" is deleted.");
			}
			else {
				System.out.println("\nID ("+id3+") does not exist");
			}
			break;
		default: 
			System.out.println("You entered a wrong number..");
		}
		System.out.println("\nThank you for using this service.\nClosing the application..");
		sc.close();
		
		//CRUD--
		/*search by id-- Employee searchById(101)--one record
		 *Update - boolean updateEmp(id, newSalary)
		 *delete - boolean deleteEmp(id)
		 * */
	}

}
