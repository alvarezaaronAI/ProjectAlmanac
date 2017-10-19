package models;

public class Faculty extends User {

	/*
	 * No new instances beyond User
	 */
	
	/*
	 * Constructor
	 */
	public Faculty(String firstName, String lastName, String email, String password) {
		super(firstName, lastName, email, password);
	}
	
	@Override
	public String toString() {
		return "Faculty: " + super.toString();
	}

}
