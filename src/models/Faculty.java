package models;

import structure.Department;
import structure.Major;
import structure.School;

public class Faculty extends User {

	/*
	 * Faculty instances
	 */
	// Only one of these three will not be null, depending on the faculty level
	School school;
	Department dept;
	Major major;
	
	/*
	 * Constructor
	 */
	public Faculty(String firstName, String lastName, String email, String password, String[] info, char level) {
		super(firstName, lastName, email, password);
		
		switch (level) {
		case 'D':
			school = determineSchool(info[0]);
			break;
		case 'M':
			School tempSchool = determineSchool(info[0]);
			if (tempSchool != null) {
				dept = school.findDept(info[1]);
			}
			break;
		case 'C':
			tempSchool = determineSchool(info[0]);
			if (tempSchool != null) {
				Department tempDept = school.findDept(info[1]);
				if (tempDept != null) {
					major = dept.findMajor(info[2]);
				}
			}
			break;
		}
	}
	
	/*
	 * Accessors
	 */
	
	public School getSchool() {
		return school;
	}
	
	public Department getDept() {
		return dept;
	}
	
	public Major getMajor() {
		return major;
	}
	
	/*
	 * Mutators
	 */
	
	public void setSchool(School school) {
		this.school = school;
	}
	
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	public void setMajor(Major major) {
		this.major = major;
	}
	
	@Override
	public String toString() {
		return "Faculty: " + super.toString();
	}

}
