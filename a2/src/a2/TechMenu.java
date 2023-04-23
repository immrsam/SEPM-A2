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
	            	if(tickets.size() > 0) {
	            		printOpenTicketHeader(); // submit ticket header
	            		openTicketOptions(input, userID); // submit ticket processes
	            	} else {
	            		System.out.println("NO OPEN TICKETS CURRENTLY");
	            	}
	                continue;
	            case 2:
	            	if(tickets.size() > 0) {
	            		printClosedTicketHeader(); // view closed ticket header
		            	closedTicketOptions(input, userID); // view existing ticket processes
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
	
	private static void openTicketOptions(Scanner input, int userID) {
		int count = 0;
		// get all open tickets that are assigned to this technician
		for(int t = 1; t <= tickets.size(); t++) {
			if(tickets.get(t).getStatus() == TicketStatus.OPEN && ticketTracker.get(t).getUserID() == userID) {
				count++;
				System.out.println("--------------------------");
				System.out.println("TicketID: " + tickets.get(t).getTicketId() + "\nUserID: " + tickets.get(t).getUserID() + "\nTicket Description: "
						+ tickets.get(t).getDescription() + "\nTicket Severity: " + tickets.get(t).getSeverity());
			}
		}
		System.out.println("Process or return to main menu: ");
		System.out.println("1. Process a ticket");
		System.out.println("2. Return to previous menu");
		System.out.print("Enter a choice: ");
		int choice = input.nextInt();
		if(choice == 1) {
			System.out.print("Enter ticket ID to process: ");
			int tktID = input.nextInt();
			if (tktID <= count) {
				tickets.get(tktID).toString(); // get ticket details
				printTicketProcessOptions(tickets.get(tktID).getSeverity()); // print open ticket options
				int techInput = input.nextInt(); // get the tech's choice of process
				openTicketProcessor(tickets.get(tktID).getTicketId(), techInput); // process open ticket
			} else {
				System.out.println("Invalid choice, please try again");
			}
		
		}
	}
	
	private static void closedTicketOptions(Scanner input, int userID) {
		// get all closed tickets that are assigned to this technician
		int count = 0;
		for(int t = 1; t <= tickets.size(); t++) {
			if (ticketTracker.get(t).getUserID() == userID) {
				if(tickets.get(t).getStatus() == TicketStatus.CLOSE_RESOLVED || tickets.get(t).getStatus() == TicketStatus.CLOSE_UNRESOLVED) {
					count++;
					System.out.println("--------------------------");
					System.out.println("TicketID: " + tickets.get(t).getTicketId() + "\nUserID: " + tickets.get(t).getUserID() + "\nTicket Description: "
							+ tickets.get(t).getDescription() + "\nTicket Severity: " + tickets.get(t).getSeverity() + "\nTicket Status: " + tickets.get(t).getStatus());
				}
			}
		}
		
		System.out.println("Process or return to main menu: ");
		System.out.println("1. Process a ticket");
		System.out.println("2. Return to previous menu");
		System.out.print("Enter a choice: ");
		int choice = input.nextInt();
		if(choice == 1) {
			System.out.print("Enter ticket ID to process: ");
			int tktID = input.nextInt();
			if (tktID <= count) {
				System.out.println("TicketID: " + tickets.get(tktID).getTicketId() + "\nUserID: " + tickets.get(tktID).getUserID() + "\nTicket Description: "
						+ tickets.get(tktID).getDescription() + "\nTicket Severity: " + tickets.get(tktID).getSeverity() + "\nTicket Status: " + tickets.get(tktID).getStatus());
				printClosedTicketProcessOptions(tickets.get(tktID).getStatus()); // print open ticket options
				int techInput = input.nextInt(); // get the tech's choice of process
				if (techInput == 1) {
					tickets.get(tktID).setStatus(TicketStatus.OPEN);
				}
			} else {
				System.out.println("Invalid choice, please try again");
			}
			
		}
	}
	
	private static void openTicketProcessor(int ticketID, int choice) {
		if(choice == 1) {
			tickets.get(ticketID).setStatus(TicketStatus.CLOSE_RESOLVED);
		} else if (choice == 2) {
			tickets.get(ticketID).setStatus(TicketStatus.CLOSE_UNRESOLVED);
		} else if (choice == 3) {
			tickets.get(ticketID).setSeverity(TicketSeverity.HIGH);
			StaffMenu.ticketTaskerProcess(ticketID);
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
		if (ticketStatus != TicketStatus.OPEN) {
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
