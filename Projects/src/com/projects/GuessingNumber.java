package com.projects;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumber {

	public static int Random() {
		Random rand = new Random();
		int rand_Int = rand.nextInt(10)+1;
		return rand_Int;
	}
	
	public static void check() {
		Scanner sc= new Scanner(System.in);
		
		int count = 0;
		
		//boolean flag= false;
		int temp = 0;
		int tempRandom = 0;
		do {
			
			System.out.println("Enter the Number");
			int number = sc.nextInt();
			temp = number;
			
			int random = Random();
			tempRandom = random;

			System.out.println("Random Number = "+random);
			if(number<=tempRandom) {
//				flag = true;
				count = count +1;
				System.out.println("YES");
				
			}
		}while(temp<=tempRandom);
		
		System.out.println("Final score = "+count);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		
		GuessingNumber.check();
		

	}

}
