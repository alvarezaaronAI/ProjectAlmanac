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
	private School school; // for all levels
	private Department dept; // for levels M,C; null otherwise
	private Major major; // for level C; null otherwise
	
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
			school = determineSchool(info[0]);
			if (school != null) {
				dept = school.findDept(info[1]);
			}
			break;
		case 'C':
			school = determineSchool(info[0]);
			if (school != null) {
				dept = school.findDept(info[1]);
				if (dept != null) {
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
	
	/*
	 * Creates a new department and adds it to the specified school
	 * Returns true if added; false if access denied or if department already exists
	 */
	public boolean addDept(String schoolStr, String deptStr) {
		if (level == 'D') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school for D
				return school.addDept(new Department(deptStr));
			}
		}
		return false;
	}
	
	/*
	 * Creates a new major and adds it to the specified department
	 * Returns true is added; false if access denied or if major already exists
	 */
	public boolean addMajor(String schoolStr, String deptStr, String majorStr) {
		if (level == 'D' || level == 'M') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school for D,M
				if (level == 'D') { // find department for D
					Department deptFound = school.findDept(deptStr);
					return deptFound.addMajor(new Major(majorStr));
				}
				else if (dept != null && dept.getName().equals(deptStr)) { // validate department for M
					return dept.addMajor(new Major(majorStr));
				}
			}
		}
		return false;
	}
	
	/*
	 * Creates a new course and adds it to the specified major
	 * Returns true is added; false if access denied or if course already exists
	 */
	public boolean addCourse(String schoolStr, String deptStr, String majorStr, String courseStr) {
		if (level == 'D' || level == 'M' || level == 'C') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school for D,M,C
				if (level == 'D' || level == 'M') { // find department for D,M
					Department deptFound = school.findDept(deptStr);
					// ...
				}
				if (dept != null && dept.getName().equals(deptStr)) { // validate department
					if (major != null && major.getName().equals(majorStr)) { // validate major
						//return major.addCourse(new Course(courseStr));
					}
				}
			}
		}
		return false;
	}
	
	public boolean removeDept(String schoolStr, String deptStr) {
		if (level == 'D') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school
				return school.removeDept(deptStr);
			}
		}
		return false;
	}
	
	public boolean removeMajor(String schoolStr, String deptStr, String majorStr) {
		if (level == 'D' || level == 'M') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school
				if (dept != null && dept.getName().equals(deptStr)) { // validate department
					return dept.removeMajor(majorStr);
				}
			}
		}
		return false;
	}
	
	public boolean removeCourse(String schoolStr, String deptStr, String majorStr, String courseStr) {
		if (level == 'D' || level == 'M' || level == 'C') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school
				if (dept != null && dept.getName().equals(deptStr)) { // validate department
					if (major != null && major.getName().equals(majorStr)) { // validate major
						return major.removeCourse(courseStr);
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Faculty: " + super.toString();
	}

}
