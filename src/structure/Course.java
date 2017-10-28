package structure;

import java.util.ArrayList;

public class Course {

	String id;
	String dept;
	int courseNum;
	String name;
	int units;
	ArrayList<Course> prereqs = new ArrayList<>();
	
	public Course(String dept, int courseNum, String name, int units) {
		id = dept + courseNum;
		this.dept = dept;
		this.courseNum = courseNum;
		this.name = name;
		this.units = units;
	}
	
	/*
	 * Accessors
	 */
	
	public String getID() {
		return id;
	}
	
	public String getDept() {
		return dept;
	}
	
	public int getCourseNum() {
		return courseNum;
	}
	
	public String getName() {
		return name;
	}
	
	public int getUnits() {
		return units;
	}
	
	/*
	 * Mutators
	 */
	
	public void setID(String id) {
		this.id = id;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setUnits(int units) {
		this.units = units;
	}
	
	public void addPrereq(Course prereq) {
		prereqs.add(prereq);
	}
	
	@Override
	public String toString() {
		return dept + " " + courseNum;
	
	}
	
}
