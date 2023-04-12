package a2;

public class Technician extends StaffMember{

	private int level;
	
	public Technician(int userId, String fName, String lName, String email,String phoneNumber, String password, int level) {
		super(userId, fName, lName, email,phoneNumber, password);
		this.level = level;

	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
