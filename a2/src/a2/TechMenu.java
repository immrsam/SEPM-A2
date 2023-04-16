package a2;

import java.util.Scanner;

public class TechMenu extends LoginMenu {

	public static void Processor(Scanner input, int userID) {
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
	            	if(tickets.size() > 1) {
	            		printOpenTicketHeader(); // submit ticket header
	            		openTicketOptions(userID); // submit ticket processes
	            	} else {
	            		System.out.println("NO TICKETS CURRENTLY");
	            	}
	                continue;
	            case 2:
	            	if(tickets.size() > 1) {
	            		printClosedTicketHeader(); // view closed ticket header
		            	closedTicketOptions(userID); // view existing ticket processes
	            	} else {
	            		System.out.println("NO TICKETS CURRENTLY");
	            	}	            	
	                continue;
	            case 3:
	            	break;
	            default:
	                System.out.println("Invalid choice, please try again");
            }
        } while (choice != 3);
		
	}
	
	private static void openTicketOptions(int userID) {
		Scanner input = new Scanner(System.in);
		
		// get all tickets that are assigned to this technician
		for(int t = 0; t < tickets.size(); t++) {
			if(tickets.get(t).getStatus() == TicketStatus.OPEN && ticketTracker.get(t).getUserID() == userID) {
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
	
	private static void closedTicketOptions(int userID) {
		Scanner input = new Scanner(System.in);
		
		for(int t = 0; t < tickets.size(); t++) {
			if (ticketTracker.get(t).getUserID() == userID) {
				if(tickets.get(t).getStatus() == TicketStatus.CLOSE_RESOLVED || tickets.get(t).getStatus() == TicketStatus.CLOSE_UNRESOLVED || tickets.get(t).getStatus() == TicketStatus.ARCHIVE) {
					tickets.get(t).toString();
				}
			}
		}
		System.out.print("Enter ticket ID to process: ");
		int tktID = input.nextInt();
		
		tickets.get(tktID).toString(); // get ticket details
		printClosedTicketProcessOptions(tickets.get(tktID).getStatus()); // print open ticket options
		int techInput = input.nextInt(); // get the tech's choice of process
		if (techInput == 1) {
			tickets.get(tktID).setStatus(TicketStatus.OPEN);
		}
		
		input.close();
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
	
	private static void printClosedTicketProcessOptions(TicketStatus ticketStatus) {
		if (ticketStatus == TicketStatus.ARCHIVE) {
			System.out.println("------------------------------");
			System.out.println("1. Mark as OPEN");
	        System.out.print("Enter your choice: ");
		}
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
