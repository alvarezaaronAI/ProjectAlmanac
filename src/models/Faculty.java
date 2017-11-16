package models;

import structure.Course;
import structure.Department;
import structure.Major;
import structure.School;

public class Faculty extends User {

	/*
	 * Faculty instances
	 */
	
	private char level; // D,M,C
	// Only one of these three will not be null, depending on the faculty level
	private School school;
	private Department dept;
	private Major major;
	
	/*
	 * Constructor
	 */
	
	public Faculty(String firstName, String lastName, String email, String password, String[] info, char level) {
		super(firstName, lastName, email, password);
		
		this.level = level;
		
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
	
	/*
	 * More
	 */
	
	public boolean addDept(Department dept) {
		if (level == 'D') {
			school.addDept(dept); // make this return a bool
			return true;
		}
		return false;
	}
	
	public boolean addMajor(Major major) {
		if (level == 'M') {
			dept.addMajor(major);
			return true;
		}
		return false;
	}
	
	public boolean addCourse(Course course) {
		if (level == 'C') {
			major.addCourse(course);
			return true;
		}
		return false;
	}
	
	public boolean removeDept(Department dept) {
		if (level == 'D') {
			school.removeDept(dept);
			return true;
		}
		return false;
	}
	
	public boolean removeMajor(Major major) {
		if (level == 'M') {
			dept.removeMajor(major);
			return true;
		}
		return false;
	}
	
	public boolean removeCourse(Course course) {
		if (level == 'C') {
			major.removeCourse(course);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Faculty: " + super.toString();
	}

}
