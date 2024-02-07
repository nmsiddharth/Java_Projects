package com.java.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeUtility {
	private static final String driverClass = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/jdbc";
	private static final String username = "root";
	private static final String password = "MySQL@2024";
	private static Connection con = null;
	static {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		if(con==null) {
			con = DriverManager.getConnection(url,username,password);
		}
		return con;
	}
	
	
	public static String addEmployee(Scanner sc) throws SQLException {
		System.out.println("Enter the Employee ID : ");
		int empId = sc.nextInt();
		System.out.println("Enter the Employee Name : ");
		String empName = sc.next();
		System.out.println("Enter the Employee Department : ");
		String empDept = sc.next();
		
		String sql = "insert into emp(id,name,dept) values(?,?,?)";
		PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
		preparedStatement.setInt(1, empId);
		preparedStatement.setString(2, empName);
		preparedStatement.setString(3, empDept);
		
		int i = preparedStatement.executeUpdate();
		if(i>0) {
			return "Employee added successfully";
		}
		return "Something went wrong";
	}
	
	public static void getAllEmployee() throws SQLException {
		String sql = "select * from emp";
		ResultSet set = getConnection().createStatement().executeQuery(sql);
		
		System.out.println("Displaying Employees Details");
		System.out.println("------------------------------------------");
		
		while(set.next()) {
			System.out.println("\tEmployeeID   \tEmployeeName   \tDepartmentName");
			System.out.println("\t"+set.getInt(1)  +"\t"+set.getString(2)+   "\t"+set.getString(3));
		}
	}
	
	public static void getEMployeeById(Scanner sc) throws SQLException {
		System.out.println("Enter the ID of Employee");
		int empId = sc.nextInt();
		
		String sql = "select * from emp where id = ?";
		PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
		preparedStatement.setInt(1, empId);
		ResultSet set = preparedStatement.executeQuery();
		
		System.out.println("Displaying Employees Details");
		System.out.println("------------------------------------------");
		
		while(set.next()) {
			System.out.println("\tEmployeeID   \tEmployeeName   \tDepartmentName");
			System.out.println("\t"+set.getInt(1)  +"\t"+set.getString(2)+   "\t"+set.getString(3));
		}
	}
	
	public static String updateEMployee(Scanner sc) throws SQLException {
		System.out.println("Enter the ID of Employee");
		int empId = sc.nextInt();
		System.out.println("Enter the Department Name");
		String empDept = sc.next();
		
		String sql = "update emp set dept = ? where id = ?";
		PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
		preparedStatement.setString(1, empDept);
		preparedStatement.setInt(2, empId);
		
		int i = preparedStatement.executeUpdate();
		if(i>0) {
			return "Employee updated successfully";
		}
		return "Something went wrong";
	}
	
	public static String deleteEmployee(Scanner sc) throws SQLException {
		System.out.println("Enter the ID of Employee");
		int empId = sc.nextInt();
		
		String sql = "delete from emp where id = ?";
		PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
		preparedStatement.setInt(1, empId);
		
		int i = preparedStatement.executeUpdate();
		if(i>0) {
			return "Employee deleted successfully";
		}
		return "Something went wrong";
	}
		
	}

