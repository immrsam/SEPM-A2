package a2;

import java.util.HashMap;
import java.util.Scanner;

public class CincoApp {
	protected static HashMap<String, StaffMember> staff = new HashMap<String, StaffMember>();
	protected static HashMap<String, Technician> tech = new HashMap<String, Technician>();
	protected static HashMap<String, SystemOwner> systemOwners = new HashMap<String, SystemOwner>();
	
	protected static HashMap<Integer, Ticket> tickets = new HashMap<Integer, Ticket>();
	protected static HashMap<Integer, Technician> ticketTracker = new HashMap<Integer, Technician>();
	
	protected static boolean appRunning = true;
	
	public static void main(String[] args) {
		// console scanner
		Scanner input = new Scanner (System.in);
		
		// variables
		int userID = 0;
				
		// Load data
		LoadData.loadAllData();
		
		do {
			userID = LoginMenu.Processor(input);
			if(Integer.toString(userID).charAt(0) == '9') {
				// userId for system owner starts with 9xxx
				SystemOwnerMenu.Processor(input, userID);
			}
			else if (Integer.toString(userID).charAt(0) == '1') {
				// userID for technician starts with 1xxx
				TechMenu.Processor(input, userID);				
			} else if (Integer.toString(userID).charAt(0) == '2') {
				// userID for staff starts with 2xxx
				StaffMenu.Processor(input, userID);
			}
		} while (appRunning);
		
		input.close();
	}
	
	

}
