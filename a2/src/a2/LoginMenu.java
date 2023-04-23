package a2;

import java.util.Scanner;

public class LoginMenu extends CincoApp{

	public static int Processor(Scanner input) {
		int userID = 0;
		int choice = 0;
		
		do {
			printLoginMenu();
			try {
				choice = input.nextInt(); // get user choice
			} catch (java.util.InputMismatchException e) {
				input.next(); // clear the invalid input from the scanner
	         System.out.println("Invalid input, please enter a number.");
	         continue;
			}
			
			switch(choice) {
			case 0:
				printSystemOwnerLoginHeader();
				System.out.print("Enter email: ");
				String soEmail = input.next();
				SystemOwner soUser = systemOwners.get(soEmail);
				if (soUser != null) {
					System.out.print("Enter password: ");
					String staffPassword = input.next();
									
					if(soUser.getPassword().equals(staffPassword)) {
						System.out.println("Found user: " + soUser.getUserID());
						System.out.println("Name: " + soUser.getfName() + " " + soUser.getlName());
						System.out.println("Phone: " + soUser.getPhoneNumber());
						System.out.println("Email: " + soUser.getEmail());
						
						// login successful - print main menu options
						userID = soUser.getUserID();
						return userID;					
					} else {
						System.out.println("Incorrect password");
						continue;
					}
				} else {
				    System.out.println("User not found, try again");
				    continue;
				}		
			case 1:
				printUserLoginHeader(); // user login option
				System.out.print("Enter email: ");
				String sEmail = input.next();
				StaffMember staffUser = staff.get(sEmail);
				
				if (staffUser != null) {
					System.out.print("Enter password: ");
					String staffPassword = input.next();
									
					if(staffUser.getPassword().equals(staffPassword)) {
						System.out.println("Found user: " + staffUser.getUserID());
						System.out.println("Name: " + staffUser.getfName() + " " + staffUser.getlName());
						System.out.println("Phone: " + staffUser.getPhoneNumber());
						System.out.println("Email: " + staffUser.getEmail());
						
						// login successful - print main menu options
						userID = staffUser.getUserID();
						return userID;					
					} else {
						System.out.println("Incorrect password");
						continue;
					}
				} else {
					System.out.println("User not found, create new account");
					createAccountOptions(input);
					continue;
				}		
			case 2:
				printTechLoginHeader(); // technician login option
				System.out.print("Enter email: ");
				String tEmail = input.next();
				Technician techUser = tech.get(tEmail);
				
				if (techUser != null) {
					System.out.print("Enter password: ");
					String techPassword = input.next();
									
					if(techUser.getPassword().equals(techPassword)) {
						System.out.println("Found user: " + techUser.getUserID());
						System.out.println("Name: " + techUser.getfName() + " " + techUser.getlName());
						System.out.println("Phone: " + techUser.getPhoneNumber());
						System.out.println("Email: " + techUser.getEmail());
						System.out.println("Level: " + techUser.getLevel());
						System.out.println("Tasks: " + techUser.getNumTasks());
						
						// login successful - print main menu options
						userID = techUser.getUserID();
						return userID;					
					} else {
						System.out.println("Incorrect password");
						continue;
					}
				} else {
				    System.out.println("User not found, try again");
				    continue;
				}
			case 3:
				printForgotPasswordHeader(); // forgot password option
				System.out.print("Enter email: ");
				String updateUsername = input.next();
				StaffMember updateUser = staff.get(updateUsername);
				if(updateUser != null) {
					System.out.print("Enter new password: ");
					String updatePassword = input.next();
					updateUser.setPassword(updatePassword);
					System.out.println("--Password Updated--");
				} else {
					System.out.println("No user with that email");
				}
				break;
			case 4:
				System.out.println("Quitting..."); // quit program option
				appRunning = false;
				break;
			default:
				System.out.println("Invalid choice, please try again");
				continue;
			}
		} while (choice != 4); 
		
		
		input.close();
		return 0;
	}
	
	// login menu header options
	public static void printLoginMenu() {
		System.out.println("----------------------");
    	System.out.println("CINCO TICKETING SYSTEM");
    	System.out.println("----------------------");
    	System.out.println("0. System Owner Login");
        System.out.println("1. Staff Login");
        System.out.println("2. Technician Login");
        System.out.println("3. Forgot Password");
        System.out.println("4. Quit");
        System.out.print("Enter your choice: ");
	}
	
	// user login header
	private static void printSystemOwnerLoginHeader() {
		System.out.println();
		System.out.println("------------");
		System.out.println("System Login ");
		System.out.println("------------");
		System.out.println();
	}
	
	// user login header
	private static void printUserLoginHeader() {
		System.out.println();
		System.out.println("-----------");
		System.out.println("Staff Login ");
		System.out.println("-----------");
		System.out.println();
	}
	
	// technician login header
	private static void printTechLoginHeader() {
		System.out.println();
		System.out.println("-----------------");
		System.out.println("Technician Login ");
		System.out.println("-----------------");
		System.out.println();
	}
	
	// forgot password header
	private static void printForgotPasswordHeader() {
		System.out.println("------------------------");
		System.out.println("Forgot Password selected");
		System.out.println("------------------------");
	}
	
	private static void createAccountOptions(Scanner input) {
		int choice = 0;
		do {
			printCreateAccountHeader();
			try {
				choice = input.nextInt(); // get user choice
			} catch (java.util.InputMismatchException e) {
				input.next(); // clear the invalid input from the scanner
	         System.out.println("Invalid input, please enter a number.");
	         continue;
			}
			
			switch(choice) {
				case 1:
					int staffID = staff.size() + 1;
					System.out.print("Enter First Name: ");
					String fname = input.next();

					System.out.print("Enter Last Name: ");
					String lname = input.next();
					
					System.out.print("Enter Email (eg. bill.smith@cinco.com): ");
					String email = input.next();

					System.out.print("Enter phone number (eg. 61412345678): ");
					String phone = input.next();

					System.out.print("Enter password: ");
					String password = input.next();

					StaffMember staffMember = new StaffMember(staffID, fname, lname, email, phone, password);

					staff.put(email, staffMember);
				case 2:
					// return to main menu
					break;

			}
		} while (choice != 2);
	}

	private static void printCreateAccountHeader() {
		System.out.println();
		System.out.println("------------------------");
		System.out.println("Create New Staff Account");
		System.out.println("------------------------");
		System.out.println("1. Create Account");
		System.out.println("2. Return to main menu");
	}
}
