package a2;

public class Technician extends StaffMember{

	private int level;
	private int numTasks;
	
	public Technician(int userID, String fName, String lName, String email, String phoneNumber, String password, int level, int numTasks) {
		super(userID, fName, lName, email, phoneNumber, password);
		this.level = level;
		this.numTasks = numTasks;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getNumTasks() {
		return numTasks;
	}

	public void setNumTasks(int numTasks) {
		this.numTasks = numTasks;
	}
}
