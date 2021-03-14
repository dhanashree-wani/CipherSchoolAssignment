/*Java assignment question-2
  Date : 14/03/2021
  Author: Dhanashree Wani
  Problem statement : Write a code for Super market budget management   system*/

import java.io.*;
import java.util.*;
public class SuperMarket {
	Scanner sc = new Scanner(System.in);
	String itemName[]=new String[5];
	int quantity[]=new int[5];
	double price[]=new double[5];
	int budget;
	public void collectBudget() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your budget: ");
		budget=sc.nextInt();
	}

	public void displayMenu() {
		int choice=0;
		do {
		 System.out.println("1.Add an item.");
                 System.out.println("2.Exit.");
		 System.out.println("Enter your choice: ");
		 choice=sc.nextInt();
		 switch(choice) {
			case 1: System.out.println("Add item.");
				break;
			case 2: System.out.println("Exit.");
				break;
			default:System.out.println("Invalid Choice.......");
				break;
		   }
	
		}while(choice<=2);

	}

	public static void main(String args[]) {
		
		
		SuperMarket s= new SuperMarket();
		s.collectBudget();
		s.displayMenu();
	}
	
}