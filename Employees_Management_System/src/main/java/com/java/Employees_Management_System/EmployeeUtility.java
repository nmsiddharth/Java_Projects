package com.java.Employees_Management_System;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeUtility {
private static SessionFactory factory = null;
	
	private static SessionFactory getSessionFactory() {
		if(factory==null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
		return factory;
	}
	
	  public static void shutdown() {
	        factory.close();
	    }
	
	public static String addEmployee(Scanner sc) {
		System.out.println("Enter the Employee ID : ");
		int empId = sc.nextInt();
		System.out.println("Enter the Employee Name : ");
		String empName = sc.next();
		System.out.println("Enter the Employee Department : ");
		String empDept = sc.next();
		
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = new Employee();
		 employee.setEmpId(empId);
         employee.setEmpName(empName);
         employee.setEmpDept(empDept);
         session.save(employee);
         session.getTransaction().commit();
 		 return "Employee added successfully";
	}
	
	public static void getAllEmployees() {
		Session session = getSessionFactory().openSession();
		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> employees = query.list();
		System.out.println("Displaying Employees Details");
        System.out.println("------------------------------------------");
        for (Employee employee : employees) {
            System.out.println("\tEmployeeID   \tEmployeeName   \tDepartmentName");
            System.out.println("\t" + employee.getEmpId() + "\t" + employee.getEmpName() + "\t" + employee.getEmpDept());
        }
	}
	
	public static void getEmployeeById(Scanner sc) {
		Session session = getSessionFactory().openSession();
		 System.out.println("Enter the ID of Employee");
         int empId = sc.nextInt();
         Employee employee = session.get(Employee.class, empId);
         if (employee != null) {
             System.out.println("Displaying Employee Details");
             System.out.println("------------------------------------------");
             System.out.println("\tEmployeeID   \tEmployeeName   \tDepartmentName");
             System.out.println("\t" + employee.getEmpId() + "\t" + employee.getEmpName() + "\t" + employee.getEmpDept());
         } else {
             System.out.println("Employee with ID " + empId + " not found.");
         }
	}
	
	public static String updateEmployee(Scanner sc) {
		Session session = getSessionFactory().openSession();
		 System.out.println("Enter the ID of Employee");
         int empId = sc.nextInt();
         Employee employee = session.get(Employee.class, empId);
         if (employee != null) {
             System.out.println("Enter the Department Name");
             String empDept = sc.next();
             session.beginTransaction();
             employee.setEmpDept(empDept);
             session.update(employee);
             session.getTransaction().commit();
             return "Employee updated successfully";
         } else {
             return "Employee with ID " + empId + " not found.";
         }
	}
	
	public static String deleteEmployee(Scanner sc) {
		Session session = getSessionFactory().openSession();
		 System.out.println("Enter the ID of Employee");
         int empId = sc.nextInt();
         Employee employee = session.get(Employee.class, empId);
         if (employee != null) {
             session.beginTransaction();
             session.delete(employee);
             session.getTransaction().commit();
             return "Employee deleted successfully";
         } else {
             return "Employee with ID " + empId + " not found.";
         }
	}
}

