package com.java;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.utility.EmployeeUtility;

public class Test {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------Employee Management System--------------");
		char res;
		do {
			System.out.println("Select Option");
			System.out.println("1.addEmployee  2.getAll  3.getById   4.updateEmployee   5.deleteEmployee");
			int option = sc.nextInt();
			
			switch(option) {
			case 1:System.out.println(EmployeeUtility.addEmployee(sc));
					break;
			case 2:EmployeeUtility.getAllEmployee();
					break;		
			
			case 3:EmployeeUtility.getEMployeeById(sc);
					break;
					
			case 4:System.out.println(EmployeeUtility.updateEMployee(sc));
					break;	
					
			case 5:System.out.println(EmployeeUtility.deleteEmployee(sc));
					break;	
					
			default: System.out.println("Invalid Option");		
			}
			System.out.println("Do you want to continue? y/n");
			res = sc.next().charAt(0);

		}while(res=='y');
		System.out.println("Thanks! Have a Good Day");
	}

}
