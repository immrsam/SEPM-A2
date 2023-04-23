package a2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SystemOwnerMenu extends CincoApp {
	public static void Processor(Scanner input, int userID) {
		int choice = 0;
		
		do {
			printSOMainMenuHeader();
			
			try {
				choice = input.nextInt(); // get user choice
			} catch (java.util.InputMismatchException e) {
				input.next(); // clear the invalid input from the scanner
				System.out.println("Invalid input, please enter a number.");
				continue;
			}
			
			switch (choice) {
				case 1:
					createReportProcessor(input);
					continue;
				case 2:
					break;
				default:
						System.out.println("Invalid choice, please try again");
			}
      } while (choice != 2);
		
	}

	private static void printSOMainMenuHeader() {
		System.out.println("-----------------");
    	System.out.println("SYSTEM OWNER MENU");
    	System.out.println("-----------------");
		System.out.println("1. Create Reports");
		System.out.println("2. System Admin");
		System.out.println("3. Return to Main Menu");
		System.out.print("Enter your choice: ");
	}

	private static void createReportsHeader() {
		System.out.println("------------------------------------------------------------------");
    	System.out.println("CREATE REPORTS MENU");
    	System.out.println("------------------------------------------------------------------");
		System.out.println("View reports for the last x numbers of days (e.g. 1 day or 7 days)");
		System.out.print("Enter numbers of days: ");
	}

	private static void createReportProcessor(Scanner input) {
		int days = 0;
		createReportsHeader();
			
		try {
			days = input.nextInt(); // get user choice
		} catch (java.util.InputMismatchException e) {
			input.next(); // clear the invalid input from the scanner
			System.out.println("Invalid input, please enter a number.");
		}

		int totalTickets = tickets.size(); 
		int numOpenTickets = 0;
		int numClosedResolvedTickets = 0;
		int numClosedUnresolvedTickets = 0;
		int numArchivedTickets = 0;
		long currentTime = new Date().getTime();
		long requestTime = currentTime - (days * 86400000);
		ArrayList<Ticket> openTickets = new ArrayList<Ticket>();
		ArrayList<Ticket> closedResolvedTickets = new ArrayList<Ticket>();
		ArrayList<Ticket> closedUnresolvedTickets = new ArrayList<Ticket>();
		ArrayList<Ticket> archivedTickets = new ArrayList<Ticket>();
		

		for(int t = 1; t <= totalTickets; t++) {
			if((tickets.get(t).getCreatedTime().getTime() >= requestTime) && (tickets.get(t).getCreatedTime().getTime() <= currentTime)) {
				if(tickets.get(t).getStatus() == TicketStatus.OPEN) {
					openTickets.add(tickets.get(t));
					numOpenTickets++;
				} else if (tickets.get(t).getStatus() == TicketStatus.CLOSE_RESOLVED) {
					closedResolvedTickets.add(tickets.get(t));
					numClosedResolvedTickets++;
				} else if (tickets.get(t).getStatus() == TicketStatus.CLOSE_UNRESOLVED) {
					closedUnresolvedTickets.add(tickets.get(t));
					numClosedUnresolvedTickets++;
				} else if (tickets.get(t).getStatus() == TicketStatus.ARCHIVED) {
					archivedTickets.add(tickets.get(t));
					numArchivedTickets++;
				}
			}
		}
		System.out.println("----------------------------------------------------");
		System.out.println("SYSTEM SUMMARY REPORT FOR " + days + " DAYS");
		System.out.println("----------------------------------------------------");
		System.out.println("Total tickets: " + totalTickets);
		System.out.println("Total open tickets: " + numOpenTickets);
		System.out.println("Total closed resolved tickets: " + numClosedResolvedTickets);
		System.out.println("Total closed unresolved tickets: " + numClosedUnresolvedTickets);
		System.out.println("Total archived tickets: " + numArchivedTickets);
		System.out.println("----------------------------------------------------");
		System.out.println("OPEN TICKETS REPORT FOR " + days + " DAYS");
		System.out.println("----------------------------------------------------");
		for(int o = 0; o < openTickets.size(); o++) {
			System.out.println("----------------------------");
			System.out.println("Created Time: " + openTickets.get(o).getCreatedTime() + "\nStaffID: " + openTickets.get(o).getUserID() 
						+ "\nTicket Severity: " + openTickets.get(o).getSeverity()); 
		}
		System.out.println("----------------------------------------------------");
		System.out.println("CLOSED RESOLVED TICKETS REPORT FOR " + days + " DAYS");
		System.out.println("----------------------------------------------------");
		for(int r = 0; r < closedResolvedTickets.size(); r++) {
			long timeElapsed = (closedResolvedTickets.get(r).getClosedTime().getTime() - closedResolvedTickets.get(r).getCreatedTime().getTime())/3600000; // elapsed time in hours
			System.out.println("Created Time: " + closedResolvedTickets.get(r).getCreatedTime() + "\nStaffID: " + closedResolvedTickets.get(r).getUserID() 
						+ "\nTicket Severity: " + closedResolvedTickets.get(r).getSeverity() + "\nProcessed by: " + closedResolvedTickets.get(r).getTechID() 
						+ "\nAttended to within: " + timeElapsed + " hrs");
			System.out.println(".................................................");
		}
		System.out.println("----------------------------------------------------");
		System.out.println("CLOSED UNRESOLVED TICKETS REPORT FOR " + days + " DAYS");
		System.out.println("----------------------------------------------------");
		for(int u = 0; u < closedUnresolvedTickets.size(); u++) {
			long timeElapsed = (closedUnresolvedTickets.get(u).getClosedTime().getTime() - closedUnresolvedTickets.get(u).getCreatedTime().getTime())/3600000; // elapsed time in hours
			System.out.println("Created Time: " + closedUnresolvedTickets.get(u).getCreatedTime() + "\nStaffID: " + closedUnresolvedTickets.get(u).getUserID() 
						+ "\nTicket Severity: " + closedUnresolvedTickets.get(u).getSeverity() + "\nProcessed by: " + closedUnresolvedTickets.get(u).getTechID() 
						+ "\nAttended to within: " + timeElapsed + " hrs");
			System.out.println(".................................................");
		}
		System.out.println("----------------------------------------------------");
		System.out.println("ARCHIVED TICKETS REPORT FOR " + days + " DAYS");
		System.out.println("----------------------------------------------------");
		for(int a = 0; a < archivedTickets.size(); a++) {
			long timeElapsed = (archivedTickets.get(a).getClosedTime().getTime() - archivedTickets.get(a).getCreatedTime().getTime())/3600000; // elapsed time in hours
			System.out.println("Created Time: " + archivedTickets.get(a).getCreatedTime() + "\nStaffID: " + archivedTickets.get(a).getUserID() 
						+ "\nTicket Severity: " + archivedTickets.get(a).getSeverity() + "\nProcessed by: " + archivedTickets.get(a).getTechID() 
						+ "\nAttended to within: " + timeElapsed + " hrs");
			System.out.println(".................................................");
		}

	}
}
