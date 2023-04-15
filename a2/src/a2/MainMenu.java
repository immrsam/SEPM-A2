package a2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
	static HashMap<Integer, Ticket> tickets = new HashMap<Integer, Ticket>();
	static HashMap<Integer, Technician> ticketTasker = new HashMap<Integer, Technician>();
	
	public static int loginProcessor(int choice) {
		Scanner input = new Scanner(System.in);
		int userID =  0;
		Map<String, StaffMember> staff = ImportData.importStaffMap();
		Map<String, Technician> tech = ImportData.importTechMap();
		
		switch(choice) {
		case 1:
			System.out.print("Enter email: ");
			String staffUsername = input.nextLine();
			System.out.print("Enter password: ");
			String staffPassword = input.nextLine();
			StaffMember sUser = staff.get(staffUsername);
			
			if (sUser != null) {
				if(sUser.getPassword().equals(staffPassword)) {
					System.out.println("Found user: " + sUser.getUserId());
					System.out.println("Name: " + sUser.getfName() + " " + sUser.getlName());
					System.out.println("Phone: " + sUser.getPhoneNumber());
					System.out.println("Email: " + sUser.getEmail());
					
					// login successful - print main menu options
					userID = staff.get(staffUsername).getUserId();
					break;					
				} else {
					System.out.println("Incorrect password");
				}
			    
			} else {
			    System.out.println("User not found, try again");
			}
			break;
		case 2:
			System.out.print("Enter email: ");
			String techUsername = input.nextLine();
			System.out.print("Enter password: ");
			String techPassword = input.nextLine();
			Technician tUser = tech.get(techUsername);
			
			if (tUser != null) {
				if(tUser.getPassword().equals(techPassword)) {
					System.out.println("Found Tech: " + tUser.getUserId());
					System.out.println("Level: " + tUser.getLevel());
					System.out.println("Name: " + tUser.getfName() + " " + tUser.getlName());
					System.out.println("Phone: " + tUser.getPhoneNumber());
					System.out.println("Email: " + tUser.getEmail());
					
					// login successful - print main menu options
					userID = tech.get(techUsername).getUserId();
					break;
					
				} else {
					System.out.println("Incorrect password");
				}
			    
			} else {
			    System.out.println("User not found, try again");
			}
			break;
		case 3:
			System.out.print("Enter email: ");
			String updateUsername = input.nextLine();
			StaffMember updateUser = staff.get(updateUsername);
			if(updateUser != null) {
				System.out.print("Enter new password: ");
				String updatePassword = input.nextLine();
				updateUser.setPassword(updatePassword);
				System.out.println("--Password Updated--");
			} else {
				System.out.println("No user with that email");
			}					
			
			break;
		default:
			break;
		}
		
		input.close();
		return userID;
	}
	
	public static int loginOptions(Scanner input) {
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
            switch (choice) {
	            case 1:
	            	printUserLoginHeader(); // user login option
	                return choice;
	            case 2:
	            	printTechLoginHeader(); // technician login option
	                return choice;
	            case 3:
	            	printForgotPasswordHeader(); // forgot password option
	                return choice;
	            case 4:
	                System.out.println("Quitting..."); // quit program option
	                return choice;
	            default:
	                System.out.println("Invalid choice, please try again");
            }
        } while (choice != 4);
        return choice;
	}
	
	public static int staffMainMenuOptions(Scanner input) {
		int choice = 0;
		 do {
			 printStaffMainMenuHeader();
			 
			 try {
	                choice = input.nextInt(); // get user choice
	            } catch (java.util.InputMismatchException e) {
	            	input.next(); // clear the invalid input from the scanner
	                System.out.println("Invalid input, please enter a number.");
	                continue;
	            }
			 switch (choice) {
	            case 1:
	            	printSubmitTicketHeader(); // submit ticket header
	                return choice;
	            case 2:
	            	printViewTicketHeader(); // view closed ticket header
	            	return choice;
	            case 3:
	            	return choice;
	            default:
	                System.out.println("Invalid choice, please try again");
            }
		 } while (choice != 3);
        return choice;
	}
	
	public static void staffMainMenuProcessor(int choice, int userID) {
        do {        	
            switch (choice) {
	            case 1:
	            	submitTicketProcessor(userID); // submit ticket processes
	                continue;
	            case 2:
	            	viewTicketProcessor(userID); // view existing ticket processes
	                continue;
	            case 3:
	            	break;
	            default:
	                System.out.println("Invalid choice, please try again");
            }
        } while (choice != 3);
	}
	
	public static int techMainMenuOptions(Scanner input) {
		int choice = 0;
		 do {
			 printTechMainMenuHeader();
			 
			 try {
	                choice = input.nextInt(); // get user choice
	            } catch (java.util.InputMismatchException e) {
	            	input.next(); // clear the invalid input from the scanner
	                System.out.println("Invalid input, please enter a number.");
	                continue;
	            }
			 switch (choice) {
	            case 1:
	            	printOpenTicketHeader(); // submit ticket header
	                return choice;
	            case 2:
	            	printClosedTicketHeader(); // view closed ticket header
	            	return choice;
	            case 3:
	            	return choice;
	            default:
	                System.out.println("Invalid choice, please try again");
            }
		 } while (choice != 3);
        return choice;
	}
	
	public static void techMainMenuProcessor(int choice, int userID) {
        do {        	
            switch (choice) {
	            case 1:
	            	openTicketProcessor(userID); // submit ticket processes
	                continue;
	            case 2:
	            	viewTicketProcessor(userID); // view existing ticket processes
	                continue;
	            case 3:
	            	break;
	            default:
	                System.out.println("Invalid choice, please try again");
            }
        } while (choice != 3);
	}
	
	private static void submitTicketProcessor(int userID) {
		Scanner input = new Scanner(System.in);
		int ticketID = tickets.size() + 1; // size of ticket HashMap + 1
		
		// get user input if IT issue Description
		System.out.print("Enter IT issue description: ");
		String tktDesc =  input.nextLine();
		
		// get user input for IT issue severity
		printSeverityHeader();
		int tktSeverityInt = input.nextInt();
		
		// using the severity/description/ticketID create new ticket, then put into tickets HashMap
		if (tktSeverityInt == 1) {
			Ticket newTicket = new Ticket(userID, ticketID, tktDesc, TicketStatus.OPEN, TicketSeverity.LOW);
			tickets.put(ticketID, newTicket); // store ticket in tickets HashMap
			ticketTaskerProcess(ticketID); // assign the ticket to a technician
		} else if (tktSeverityInt == 2) {
			Ticket newTicket = new Ticket(userID, ticketID, tktDesc, TicketStatus.OPEN, TicketSeverity.MEDIUM);
			tickets.put(ticketID, newTicket); // store ticket in tickets HashMap
			ticketTaskerProcess(ticketID); // assign the ticket to a technician
		} else if (tktSeverityInt == 3) {
			Ticket newTicket = new Ticket(userID, ticketID, tktDesc, TicketStatus.OPEN, TicketSeverity.HIGH);
			tickets.put(ticketID, newTicket); // store ticket in tickets HashMap
			ticketTaskerProcess(ticketID); // assign the ticket to a technician
		}		
		
		input.close();
	}
	private static void ticketTaskerProcess(int tktID) {
		// Hard coded Tech Emails
		String[] techID = {"harrystyles@cinco.com", "niallhoran@cinco.com", "liampayne@cinco.com", "louistomlinson@cinco.com", "zaynmalik@cinco.com"};
		Map<String, Technician> tech = ImportData.importTechMap();
		int num = 0;
		for (int i = 0; i < 4; i++) {
			for(int j = i + 1; j < 4; j++) {
				if(tech.get(techID[i]).getNumTasks() > tech.get(techID[j]).getNumTasks()) {
					num = i;
					int currentTasks = tech.get(i).getNumTasks();
					tech.get(i).setNumTasks(currentTasks + 1);
				}
			}
		}
		
		ticketTasker.put(tktID, tech.get(techID[num]));
	}  
	
	private static void viewTicketProcessor(int userID) {
		// loop through all the tickets and get the tickets for current staff (using user ID)
		// only display OPEN tickets
		for(int t = 0; t < tickets.size(); t++) {
			if(tickets.get(t).getUserID() == userID && tickets.get(t).getStatus() == TicketStatus.OPEN) {
				tickets.get(t).toString();
			}
		}
	}
	
	private static void openTicketProcessor(int userID) {
		Scanner input = new Scanner(System.in);
		
		// get all tickets that are assigned to this technician
		for(int t = 0; t < tickets.size(); t++) {
			if(tickets.get(t).getStatus() == TicketStatus.OPEN && ticketTasker.get(t).getUserId() == userID) {
				tickets.get(t).toString();
			}
		}
		System.out.print("Enter ticket ID to process: ");
		int tktID = input.nextInt();
		
		tickets.get(tktID).toString(); // get ticket details
		printTicketProcessOptions(tickets.get(tktID).getSeverity()); // print open ticket options
		int techInput = input.nextInt(); // get the tech's choice of process
		openTicketProcessor(tickets.get(tktID).getTicketId(), techInput); // process open ticket
		
		input.close();
	}
	
	private static void closedTicketProcessor(int userID) {
		Scanner input = new Scanner(System.in);
		
		for(int t = 0; t < tickets.size(); t++) {
			if (ticketTasker.get(t).getUserId() == userID) {
				if(tickets.get(t).getStatus() == TicketStatus.CLOSE_RESOLVED || tickets.get(t).getStatus() == TicketStatus.CLOSE_UNRESOLVED || tickets.get(t).getStatus() == TicketStatus.ARCHIVE) {
					tickets.get(t).toString();
				}
			}
		}
		System.out.print("Enter ticket ID to process: ");
		input.nextInt();
		
		
		input.close();
	}
	
	private static void printTicketProcessOptions(TicketSeverity tktSeverity) {
		if (tktSeverity == TicketSeverity.LOW || tktSeverity == TicketSeverity.MEDIUM) {
			System.out.println("------------------------------");
			System.out.println("1. Mark as CLOSED - RESOLVED");
	        System.out.println("2. Mark as CLOSED - UNRESOLVED");
	        System.out.println("3. Escalate to Level 2");
	        System.out.print("Enter your choice: ");
		} else if (tktSeverity == TicketSeverity.HIGH) {
			System.out.println("------------------------------");
	        System.out.println("1. Mark as CLOSED - RESOLVED");
	        System.out.println("2. Mark as CLOSED - UNRESOLVED");
	        System.out.print("Enter your choice: ");
		}	
	}
	
	private static void openTicketProcessor(int ticketID, int choice) {
		if(choice == 1) {
			tickets.get(ticketID).setStatus(TicketStatus.CLOSE_RESOLVED);
		} else if (choice == 2) {
			tickets.get(ticketID).setStatus(TicketStatus.CLOSE_UNRESOLVED);
		} else if (choice == 3) {
			tickets.get(ticketID).setSeverity(TicketSeverity.HIGH);
		}
	}
	

	private static void printStaffMainMenuHeader( ) {
		System.out.println("----------");
    	System.out.println("MAIN MENU");
    	System.out.println("----------");
    	System.out.println("1. Submit new IT issue");
        System.out.println("2. View existing IT issue(s)");
        System.out.println("3. Return to Main Menu");
        System.out.print("Enter your choice: ");
    	
	}
	
	private static void printTechMainMenuHeader( ) {
		System.out.println("----------");
    	System.out.println("MAIN MENU");
    	System.out.println("----------");
    	System.out.println("1. View OPEN Tickets");
        System.out.println("2. View CLOSED Tickets");
        System.out.println("3. Return to Main Menu");
        System.out.print("Enter your choice: ");
    	
	}
	
	private static void printLoginMenu() {
		System.out.println("----------------------");
    	System.out.println("CINCO TICKETING SYSTEM");
    	System.out.println("----------------------");
        System.out.println("1. Staff Login");
        System.out.println("2. Technician Login");
        System.out.println("3. Forgot Password");
        System.out.println("4. Quit");
        System.out.print("Enter your choice: ");
	}
	
	private static void printUserLoginHeader() {
		System.out.println();
		System.out.println("-----------");
		System.out.println("User Login ");
		System.out.println("-----------");
		System.out.println();
	}
	
	private static void printTechLoginHeader() {
		System.out.println();
		System.out.println("-----------------");
		System.out.println("Technician Login ");
		System.out.println("-----------------");
		System.out.println();
	}
	
	private static void printForgotPasswordHeader() {
		System.out.println("--------------");
		System.out.println("Forgot Password selected");
		System.out.println("--------------");
	}
	
	private static void printSubmitTicketHeader() {
		System.out.println();
		System.out.println("--------------------");
		System.out.println("Submit new IT issue ");
		System.out.println("--------------------");
		System.out.println();
	}
	
	private static void printViewTicketHeader() {
		System.out.println();
		System.out.println("--------------------------");
		System.out.println("View existing IT issue(s) ");
		System.out.println("--------------------------");
		System.out.println();
	}
	
	private static void printSeverityHeader() {
		System.out.println("Select Severity:");
		System.out.println("1. Low");
        System.out.println("2. Medium");
        System.out.println("3. High");
        System.out.print("Enter your choice: ");
	}

	private static void printOpenTicketHeader() {
		System.out.println();
		System.out.println("-------------");
		System.out.println("OPEN Tickets ");
		System.out.println("-------------");
		System.out.println();
	}
	
	private static void printClosedTicketHeader() {
		System.out.println();
		System.out.println("-------------");
		System.out.println("CLOSED Tickets ");
		System.out.println("-------------");
		System.out.println();
	}
}
