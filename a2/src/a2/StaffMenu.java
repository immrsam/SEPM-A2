package a2;

import java.util.Scanner;

public class StaffMenu extends LoginMenu{

	public static void Processor(Scanner input, int userID) {
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
	            	submitTicketProcessor(input, userID); // submit ticket processes
	                continue;
	            case 2:
	            	printViewTicketHeader(); // view closed ticket header
	            	viewTicketProcessor(userID); // view existing ticket processes
	                continue;
	            case 3:
	            	break;
	            default:
	                System.out.println("Invalid choice, please try again");
            }
        } while (choice != 3);
	}
	
	private static void submitTicketProcessor(Scanner input, int userID) {
		int ticketID = tickets.size() + 1; // size of ticket HashMap + 1
		
		// get user input if IT issue Description
		System.out.print("Enter IT issue description: ");
		String tktDesc =  input.next();
		
		// get user input for IT issue severity
		printSeverityHeader();
		int tktSeverityInt = input.nextInt();
		
		// using the severity/description/ticketID create new ticket, then put into tickets HashMap
		if (tktSeverityInt == 1) {
			Ticket newTicket = new Ticket(userID, ticketID, tktDesc, TicketStatus.OPEN, TicketSeverity.LOW);
			tickets.put(ticketID, newTicket); // store ticket in tickets HashMap
//			ticketTaskerProcess(ticketID); // assign the ticket to a technician
		} else if (tktSeverityInt == 2) {
			Ticket newTicket = new Ticket(userID, ticketID, tktDesc, TicketStatus.OPEN, TicketSeverity.MEDIUM);
			tickets.put(ticketID, newTicket); // store ticket in tickets HashMap
//			ticketTaskerProcess(ticketID); // assign the ticket to a technician
		} else if (tktSeverityInt == 3) {
			Ticket newTicket = new Ticket(userID, ticketID, tktDesc, TicketStatus.OPEN, TicketSeverity.HIGH);
			tickets.put(ticketID, newTicket); // store ticket in tickets HashMap
//			ticketTaskerProcess(ticketID); // assign the ticket to a technician
		}		
	}
	
	private static void viewTicketProcessor(int userID) {
		// loop through all the tickets and get the tickets for current staff (using user ID)
		// only display OPEN tickets
		for(int t = 1; t <= tickets.size(); t++) {
			if(tickets.get(t).getUserID() == userID && tickets.get(t).getStatus() == TicketStatus.OPEN) {
				System.out.println("----------------------------------------");
				System.out.println("TicketID: " + tickets.get(t).getTicketId() + "\nTicket Description: " + tickets.get(t).getDescription() + "\nTicket Severity: " + tickets.get(t).getSeverity());
				
			}
		}
	}
	
	/*
	 * private static void ticketTaskerProcess(int tktID) { // Hard coded Tech
	 * Emails String[] techID = {"harrystyles@cinco.com", "niallhoran@cinco.com",
	 * "liampayne@cinco.com", "louistomlinson@cinco.com", "zaynmalik@cinco.com"};
	 * int num = 0; for (int i = 0; i <= 4; i++) { for(int j = i + 1; j < 3; j++) {
	 * if(tech.get(techID[i]).getNumTasks() > tech.get(techID[j]).getNumTasks()) {
	 * num = i; int currentTasks = tech.get(techID[i]).getNumTasks();
	 * tech.get(techID[i]).setNumTasks(currentTasks + 1); } } }
	 * 
	 * ticketTracker.put(tktID, tech.get(techID[num])); }
	 */	
	private static void printStaffMainMenuHeader( ) {
		System.out.println("----------");
    	System.out.println("MAIN MENU");
    	System.out.println("----------");
    	System.out.println("1. Submit new IT issue");
        System.out.println("2. View existing IT issue(s)");
        System.out.println("3. Return to Main Menu");
        System.out.print("Enter your choice: ");
    	
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
}
