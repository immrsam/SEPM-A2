package a2;

import java.util.HashMap;
import java.util.Scanner;

public class CincoApp {
	protected static HashMap<String, StaffMember> staff = new HashMap<String, StaffMember>();
	protected static HashMap<String, Technician> tech = new HashMap<String, Technician>();
	
	protected static HashMap<Integer, Ticket> tickets = new HashMap<Integer, Ticket>();
	protected static HashMap<Integer, Technician> ticketTracker = new HashMap<Integer, Technician>();
	
	protected static boolean appRunning = true;
	
	public static void main(String[] args) {
		// console scanner
		Scanner input = new Scanner (System.in);
		
		// variables
		int userID = 0;
		
		
		// Load data
		LoadData.LoadStaff();
		LoadData.LoadTechnicians();
		
		do {
			userID = LoginMenu.Processor(input);
			if (Integer.toString(userID).charAt(0) == '1') {
				// userID is for technician
				TechMenu.Processor(input, userID);				
			} else if (Integer.toString(userID).charAt(0) == '2') {
				// userID is for staff
				StaffMenu.Processor(input, userID);
			}
		} while (appRunning);
		
		input.close();
	}
	
	

}
