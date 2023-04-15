package a2;

import java.util.Scanner;

public class CincoApp {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int userInput;
		int userID;
		
		boolean appRunning = true;
		
		do {
			// login process
			userInput = MainMenu.loginOptions(input);
			input.nextLine();
			userID = MainMenu.loginProcessor(userInput);
						
			// main menu process
			if (userInput == 1) {
				MainMenu.staffMainMenuOptions(input, userID);
				continue;
			} else if (userInput == 2) {
				MainMenu.techMainMenuOptions(input, userID);
				continue;
			}
			
		} while (appRunning);
		
		input.close();
	}

}