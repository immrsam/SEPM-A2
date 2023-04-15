package a2;

import java.util.Scanner;

public class CincoApp {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int loginInput, staffMenuInput, techMenuInput;
		int userID;
		
		boolean appRunning = true;
		
		do {
			// login process
			loginInput = MainMenu.loginOptions(input);
			userID = MainMenu.loginProcessor(loginInput);
			
			// main menu process
			if (loginInput == 1) {
				staffMenuInput = MainMenu.staffMainMenuOptions(input);
				MainMenu.staffMainMenuProcessor(staffMenuInput, userID);
				continue;
			} else if (loginInput == 2) {
				techMenuInput = MainMenu.techMainMenuOptions(input);
				MainMenu.techMainMenuProcessor(techMenuInput, userID);
				continue;
			}
			
		} while (appRunning);
		
		input.close();
	}
}