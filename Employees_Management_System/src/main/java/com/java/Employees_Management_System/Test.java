package com.java.Employees_Management_System;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------Employee Management System--------------");
		char res;
		do {
			System.out.println("Select Option");
			System.out.println("1.addEmployee  2.getAll  3.getById   4.updateEmployee   5.deleteEmployee");
			int option = sc.nextInt();
			
			switch (option) {
            case 1:
                System.out.println(EmployeeUtility.addEmployee(sc));
                break;
            case 2:
                EmployeeUtility.getAllEmployees();
                break;
            case 3:
                EmployeeUtility.getEmployeeById(sc);
                break;
            case 4:
                System.out.println(EmployeeUtility.updateEmployee(sc));
                break;
            case 5:
                System.out.println(EmployeeUtility.deleteEmployee(sc));
                break;
            default:
                System.out.println("Invalid Option");
        }
        System.out.println("Do you want to continue? y/n");
        res = sc.next().charAt(0);

    } while (res == 'y');
    EmployeeUtility.shutdown();
    System.out.println("Thanks! Have a Good Day");
}

	}


