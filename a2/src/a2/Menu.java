package a2;

import java.util.Scanner;

public class Menu {
	public static int Login(Scanner input) {		 
        int choice = 0;
        do {
        	System.out.println("----------------------");
        	System.out.println("CINCO TICKETING SYSTEM");
        	System.out.println("----------------------");
            System.out.println("1. Login");
            System.out.println("2. Forgot Password");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            try {
                choice = input.nextInt();
            } catch (java.util.InputMismatchException e) {
            	input.next(); // clear the invalid input from the scanner
                System.out.println("Invalid input, please enter a number.");
                continue;
            }
            switch (choice) {
                case 1:
                    loginUser();
                    return choice;
//                    break;
                case 2:
                    forgotPassword();
                    return choice;
//                    break;
                case 3:
                    System.out.println("Quitting...");
                    return choice;
//                    break;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        } while (choice != 3);
        return choice;
	}
	
	private static void loginUser() {
		System.out.println();
		System.out.println("-----------");
		System.out.println("User Login ");
		System.out.println("-----------");
		System.out.println();
		
	}
	
	private static void forgotPassword() {
		System.out.println("--------------");
		System.out.println("Forgot Password selected");
		System.out.println("--------------");
	}
}
