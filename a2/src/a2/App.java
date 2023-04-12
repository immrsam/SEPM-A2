package a2;
import java.util.Map;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int menuChoice;
		Map<String, StaffMember> staff = ImportData.importStaffMap();
		boolean looping = true;

		do {
			menuChoice = Menu.Login(input);
			input.nextLine();

			switch(menuChoice) {
				case 1:
					System.out.print("Enter email: ");
					String username = input.nextLine();
					if(username.equalsIgnoreCase("quit")) {
						break;
					};
					System.out.print("Enter password: ");
					String password = input.nextLine();
					StaffMember user = staff.get(username);
					if (user != null) {
						if(user.getPassword().equals(password)) {
							System.out.println("Found user: " + user.getUserId());
							System.out.println("Name: " + user.getfName() + " " + user.getlName());
							System.out.println("Phone: " + user.getPhoneNumber());
							System.out.println("Email: " + user.getEmail());
							looping = false;
						}
						else {
							System.out.println("Incorrect Username or Password");
						}

					} else {
					    System.out.println("Incorrect Username or Password");
					}
					break;
				case 2:
					System.out.print("Enter email: ");
					String updateUsername = input.nextLine();
					StaffMember updateUser = staff.get(updateUsername);
					if(updateUser != null) {
						System.out.print("Enter new password: ");
						String updatePassword = input.nextLine();
						updateUser.setPassword(updatePassword);
						System.out.println("--Password Updated--");
					}else {
						System.out.println("No user with that email");
					}

					break;
				case 3:
					looping = false;
					break;
				default:
					break;
			}

		} while (looping);

		input.close();

	}
}
