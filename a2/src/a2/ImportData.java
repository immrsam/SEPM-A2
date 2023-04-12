package a2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ImportData {

	public static ArrayList<StaffMember> importStaff() {
		ArrayList<StaffMember> staff = new ArrayList<StaffMember>();
		File file = new File("data.csv");
		try {
		    Scanner scanner = new Scanner(file);
		    // skip the header row
		    scanner.nextLine();
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();

		        String[] fields = line.split(",");
		        int id = Integer.parseInt(fields[0]);
		        String firstName = fields[1];
		        String lastName = fields[2];
		        String email = fields[3];
		        String phoneNumber = fields[4];
		        String password = fields[5];

		        StaffMember user = new StaffMember(id, firstName, lastName, email,phoneNumber ,password);
		        staff.add(user);
		    }
		    scanner.close();
		} catch (FileNotFoundException e) {
		    System.out.println("File not found: " + e.getMessage());
		}

		return staff;

	}

	public static Map<String, StaffMember> importStaffMap() {
		Map<String, StaffMember> staff = new HashMap<>();
		File file = new File("data.csv");
		try {
		    Scanner scanner = new Scanner(file);
		    scanner.nextLine();
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();

		        String[] fields = line.split(",");
		        int id = Integer.parseInt(fields[0]);
		        String firstName = fields[1];
		        String lastName = fields[2];
		        String email = fields[3];
		        String phoneNumber = fields[4];
		        String password = fields[5];

		        StaffMember user = new StaffMember(id, firstName, lastName, email,phoneNumber, password);

		        staff.put(email ,user);
		    }
		    scanner.close();
		} catch (FileNotFoundException e) {
		    System.out.println("File not found: " + e.getMessage());
		}

		return staff;

	}
}
