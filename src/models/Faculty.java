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
	private School school; // for all levels D,M,C
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
	 * Available for level D
	 * Returns true if added; false if access denied / department already exists / invalid parameters
	 */
	public boolean addDept(String schoolName, Department newDept) {
		if (level == 'D') {
			if (school != null && school.getName().equals(schoolName)) { // validate school
				return school.addDept(newDept);
			}
		}
		return false;
	}
	
	/*
	 * Creates a new major and adds it to the specified department
	 * Available for levels D, M
	 * Returns true if added; false if access denied / major already exists / invalid parameters
	 */
	public boolean addMajor(String schoolName, String deptName, Major newMajor) {		
		if (level == 'D') {
			if (school != null && school.getName().equals(schoolName)) { // validate school
				Department deptFound = school.findDept(deptName); // find department
				if (deptFound != null) {
					return deptFound.addMajor(newMajor);
				}
			}
		} else if (level == 'M') {
			if (school != null && school.getName().equals(schoolName)) { // validate school
				if (dept != null && dept.getName().equals(deptName)) { // validate department
					return dept.addMajor(newMajor);
				}
			}
		}
		return false;
	}
	
	/*
	 * Creates a new course and adds it to the specified major
	 * Available for levels D, M, C
	 * Returns true if added; false if access denied / course already exists / invalid parameters
	 */
	public boolean addCourse(String schoolName, String deptName, String majorName, Course newCourse) {		
		if (level == 'D') {
			if (school != null && school.getName().equals(schoolName)) { // validate school
				Department deptFound = school.findDept(deptName); // find department
				if (deptFound != null) {
					Major majorFound = deptFound.findMajor(majorName); // find major
					if (majorFound != null) {
						return majorFound.addCourse(newCourse);
					}
				}
			}
		} else if (level == 'M') {
			if (school != null && school.getName().equals(schoolName)) { // validate school
				if (dept != null && dept.getName().equals(deptName)) { // validate department
					Major majorFound = dept.findMajor(majorName); // find major
					if (majorFound != null) {
						return majorFound.addCourse(newCourse);
					}
				}
			}
		} else if (level == 'C') {
			if (school != null && school.getName().equals(schoolName)) { // validate school
				if (dept != null && dept.getName().equals(deptName)) { // validate department
					if (major != null && major.getName().equals(majorName)) { // validate major
						return major.addCourse(newCourse);
					}
				}
			}
		}
		return false;
	}
	
	/*
	 * Removes a department from a specified school
	 * Available for level D
	 * Returns true if removed; false if access denied / department not found / invalid parameters
	 */
	public boolean removeDept(String schoolName, String deptName) {
		if (level == 'D') {
			if (school != null && school.getName().equals(schoolName)) { // validate school
				return school.removeDept(deptName);
			}
		}
		return false;
	}
	
	/*
	 * Removes a major from a specified department
	 * Available for levels D, M
	 * Returns true if removed; false if access denied / major not found / invalid parameters
	 */
	public boolean removeMajor(String schoolName, String deptName, String majorName) {		
		if (level == 'D') {
			if (school != null && school.getName().equals(schoolName)) { // validate school
				Department deptFound = school.findDept(deptName); // find department
				if (deptFound != null) {
					return deptFound.removeMajor(majorName);
				}
			}
		} else if (level == 'M') {
			if (school != null && school.getName().equals(schoolName)) { // validate school
				if (dept != null && dept.getName().equals(deptName)) { // validate department
					return dept.removeMajor(majorName);
				}
			}
		}
		return false;
	}
	
	/*
	 * Removes a course from a specified major
	 * Available for levels D, M, C
	 * Returns true if removed; false if access denied / course not found / invalid parameters
	 */
	public boolean removeCourse(String schoolName, String deptName, String majorName, String courseID) {
		if (level == 'D') {
			if (school != null && school.getName().equals(schoolName)) { // validate school
				Department deptFound = school.findDept(deptName); // find department
				if (deptFound != null) {
					Major majorFound = deptFound.findMajor(majorName); // find major
					if (majorFound != null) {
						return majorFound.removeCourse(courseID);
					}
				}
			}
		} else if (level == 'M') {
			if (school != null && school.getName().equals(schoolName)) { // validate school
				if (dept != null && dept.getName().equals(deptName)) { // validate department
					Major majorFound = dept.findMajor(majorName); // find major
					if (majorFound != null) {
						return majorFound.removeCourse(courseID);
					}
				}
			}
		} else if (level == 'C') {
			if (school != null && school.getName().equals(schoolName)) { // validate school
				if (dept != null && dept.getName().equals(deptName)) { // validate department
					if (major != null && major.getName().equals(majorName)) { // validate major
						return major.removeCourse(courseID);
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
