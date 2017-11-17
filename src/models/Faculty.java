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
	 * Returns true if added; false if access denied / department already exists / invalid parameters
	 */
	public boolean addDept(String schoolStr, String deptStr) {
		if (level == 'D') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school
				return school.addDept(new Department(deptStr));
			}
		}
		return false;
	}
	
	/*
	 * Creates a new major and adds it to the specified department
	 * Returns true if added; false if access denied / major already exists / invalid parameters
	 */
	public boolean addMajor(String schoolStr, String deptStr, String majorStr) {		
		if (level == 'D') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school
				Department deptFound = school.findDept(deptStr); // find department
				if (deptFound != null) {
					return deptFound.addMajor(new Major(majorStr));
				}
			}
		} else if (level == 'M') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school
				if (dept != null && dept.getName().equals(deptStr)) { // validate department
					return dept.addMajor(new Major(majorStr));
				}
			}
		}
		return false;
	}
	
	/*
	 * Creates a new course and adds it to the specified major
	 * Returns true if added; false if access denied / course already exists / invalid parameters
	 */
	public boolean addCourse(String schoolStr, String deptStr, String majorStr, String courseStr) {		
		if (level == 'D') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school
				Department deptFound = school.findDept(deptStr); // find department
				if (deptFound != null) {
					Major majorFound = deptFound.findMajor(majorStr); // find major
					if (majorFound != null) {
						//return majorFound.addCourse(new Course(courseStr));
					}
				}
			}
		} else if (level == 'M') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school
				if (dept != null && dept.getName().equals(deptStr)) { // validate department
					Major majorFound = dept.findMajor(majorStr); // find major
					if (majorFound != null) {
						//return majorFound.addCourse(new Course(courseStr));
					}
				}
			}
		} else if (level == 'C') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school
				if (dept != null && dept.getName().equals(deptStr)) { // validate department
					if (major != null && major.getName().equals(majorStr)) { // validate major
						//return major.addCourse(new Course(courseStr));
					}
				}
			}
		}
		return false;
	}
	
	/*
	 * Removes a department from a specified school
	 * Returns true if removed; false if access denied / department not found / invalid parameters
	 */
	public boolean removeDept(String schoolStr, String deptStr) {
		if (level == 'D') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school
				return school.removeDept(deptStr);
			}
		}
		return false;
	}
	
	/*
	 * Removes a major from a specified department
	 * Returns true if removed; false if access denied / major not found / invalid parameters
	 */
	public boolean removeMajor(String schoolStr, String deptStr, String majorStr) {		
		if (level == 'D') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school
				Department deptFound = school.findDept(deptStr); // find department
				if (deptFound != null) {
					return deptFound.removeMajor(majorStr);
				}
			}
		} else if (level == 'M') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school
				if (dept != null && dept.getName().equals(deptStr)) { // validate department
					return dept.removeMajor(majorStr);
				}
			}
		}
		return false;
	}
	
	/*
	 * Removes a course from a specified major
	 * Returns true if removed; false if access denied / course not found / invalid parameters
	 */
	public boolean removeCourse(String schoolStr, String deptStr, String majorStr, String courseStr) {
		if (level == 'D') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school
				Department deptFound = school.findDept(deptStr); // find department
				if (deptFound != null) {
					Major majorFound = deptFound.findMajor(majorStr); // find major
					if (majorFound != null) {
						return majorFound.removeCourse(courseStr);
					}
				}
			}
		} else if (level == 'M') {
			if (school != null && school.getName().equals(schoolStr)) { // validate school
				if (dept != null && dept.getName().equals(deptStr)) { // validate department
					Major majorFound = dept.findMajor(majorStr); // find major
					if (majorFound != null) {
						return majorFound.removeCourse(courseStr);
					}
				}
			}
		} else if (level == 'C') {
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
