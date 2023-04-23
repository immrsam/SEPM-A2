package a2;

import java.util.Date;
import java.util.Scanner;

public class StaffMenu extends LoginMenu {

	// staff main menu processor
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

	// process submit new ticket
	private static void submitTicketProcessor(Scanner input, int userID) {
		int ticketID = tickets.size() + 1; // size of ticket HashMap + 1

		// get user input if IT issue Description
		System.out.println("Enter IT issue description: ");
		input.nextLine(); // to stop it from skipping this entry
		String tktDesc = input.nextLine();

		// get user input for IT issue severity
		printSeverityHeader();
		int tktSeverityInt = input.nextInt();

		Date date = new Date();

		// using the severity/description/ticketID create new ticket, then put into
		// tickets HashMap
		if (tktSeverityInt == 1) {
			Ticket newTicket = new Ticket(userID, ticketID, tktDesc, TicketStatus.OPEN, TicketSeverity.LOW, date);
			tickets.put(ticketID, newTicket); // store ticket in tickets HashMap
			ticketTaskerProcess(ticketID); // assign the ticket to a technician
		} else if (tktSeverityInt == 2) {
			Ticket newTicket = new Ticket(userID, ticketID, tktDesc, TicketStatus.OPEN, TicketSeverity.MEDIUM, date);
			tickets.put(ticketID, newTicket); // store ticket in tickets HashMap
			ticketTaskerProcess(ticketID); // assign the ticket to a technician
		} else if (tktSeverityInt == 3) {
			Ticket newTicket = new Ticket(userID, ticketID, tktDesc, TicketStatus.OPEN, TicketSeverity.HIGH, date);
			tickets.put(ticketID, newTicket); // store ticket in tickets HashMap
			ticketTaskerProcess(ticketID); // assign the ticket to a technician
		}
	}

	// process view tickets from staff currently logged in
	private static void viewTicketProcessor(int userID) {
		// loop through all the tickets and get the tickets for current staff (using
		// user ID)
		// only display OPEN tickets
		for (int t = 1; t <= tickets.size(); t++) {
			if (tickets.get(t).getUserID() == userID && tickets.get(t).getStatus() == TicketStatus.OPEN) {
				System.out.println("--------------------------");
				System.out.println("TicketID: " + tickets.get(t).getTicketId() + "\nTicket Description: "
						+ tickets.get(t).getDescription() + "\nTicket Severity: " + tickets.get(t).getSeverity());

			}
		}
	}

	// ticket tasker assigns new tickets to technicians with least tickets
	public static void ticketTaskerProcess(int tktID) { 
		// Hard coded Tech Emails 
		String[] techID1 = {"harry.styles@cinco.com", "naill.horan@cinco.com", "liam.payne@cinco.com"}; // level 1 techs
		String[] techID2 = {"louis.tomlinson@cinco.com", "zayn.malik@cinco.com"}; // level 2 techs

		// level 2 techs
		if(tickets.get(tktID).getSeverity() == TicketSeverity.HIGH) {
			if(tech.get(techID2[0]).getNumTasks() <= tech.get(techID2[1]).getNumTasks()) {
				// louis has same number of tasks or less, assign task to louis
				ticketTracker.put(tktID, tech.get(techID2[0]));
				tech.get(techID2[0]).setNumTasks(tech.get(techID2[0]).getNumTasks() + 1); // increase task + 1
			} else {
				// zayn has less number of tasks, assign task to zayn
				ticketTracker.put(tktID, tech.get(techID2[1]));
				tech.get(techID2[1]).setNumTasks(tech.get(techID2[1]).getNumTasks() + 1); // increase task + 1
			}
		} else { // level 1 techs
			if((tech.get(techID1[0]).getNumTasks() <= tech.get(techID1[1]).getNumTasks()) && (tech.get(techID1[0]).getNumTasks() <= tech.get(techID1[2]).getNumTasks())) {
				// harry has same number of tasks or less, assign task to harry
				ticketTracker.put(tktID, tech.get(techID1[0]));
				tech.get(techID1[0]).setNumTasks(tech.get(techID1[0]).getNumTasks() + 1); // increase task + 1
			} else if((tech.get(techID1[1]).getNumTasks() <= tech.get(techID1[0]).getNumTasks()) && (tech.get(techID1[1]).getNumTasks() <= tech.get(techID1[2]).getNumTasks())) {
				// naill has same number of tasks or less, assign task to naill
				ticketTracker.put(tktID, tech.get(techID1[1]));
				tech.get(techID1[1]).setNumTasks(tech.get(techID1[1]).getNumTasks() + 1); // increase task + 1
			} else {
				// liam has less number of tasks, assign task to liam
				ticketTracker.put(tktID, tech.get(techID1[2]));
				tech.get(techID1[2]).setNumTasks(tech.get(techID1[2]).getNumTasks() + 1); // increase task + 1
			}
		}
	}
	
	// Menu headers / options ---------------------------------------------------------------
	private static void printStaffMainMenuHeader() {
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
