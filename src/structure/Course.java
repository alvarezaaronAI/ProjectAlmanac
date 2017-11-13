package structure;

import java.util.ArrayList;

public class Course {

	private String id;
	private String dept;
	private int courseNum;
	private String name;
	private int units;
	private ArrayList<Course> prereqs = new ArrayList<>();
	private ArrayList<String> semesters = new ArrayList<>();
	
	/*
	 * Constructors
	 */
	
	public Course(String dept, int courseNum, String name, int units, ArrayList<String> semesters) {
		id = dept + courseNum;
		this.dept = dept;
		this.courseNum = courseNum;
		this.name = name;
		this.units = units;
		this.semesters = semesters;
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
	
	public ArrayList<Course> getPrereqs() {
		return prereqs;
	}
	
	public ArrayList<String> getSemesters() {
		return semesters;
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
	
	public void setPrereqs(ArrayList<Course> prereqs) {
		this.prereqs = prereqs;
	}
	
	public void setSemesters(ArrayList<String> semesters) {
		this.semesters = semesters;
	}
	
	/*
	 * Others
	 */
	
	public void addPrereq(Course prereq) {
		prereqs.add(prereq);
	}
	
	public void removePrereq(Course prereq) {
		prereqs.remove(prereq);
	}
	
	public void addSemester(String semester) {
		semesters.add(semester);
	}
	
	public boolean isOffered(String semester) {
		return semesters.contains(semester);
	}
	
	@Override
	public String toString() {
		String sems = new String();
		for (String s : semesters) {
			sems += s + " ";
		}
		return dept + " " + courseNum + " " + name + " " + units + " " + sems;
	}
	
}
