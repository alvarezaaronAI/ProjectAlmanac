package structure;

import java.util.ArrayList;

public class Major {

	private int id;
	private String name;
	private ArrayList<Course> courses = new ArrayList<>();
	
	/*
	 * Constructors
	 */
	
	public Major(String name) {
		this.name = name;
	}
	
	/*
	 * Accessors
	 */
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	/*
	 * Mutators
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	/*
	 * Others
	 */
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public void removeCourse(Course course) {
		courses.remove(course);
	}
	
	public Course findCourse(String courseID) {
		for (Course c : courses) {
			if (c.getID().equals(courseID)) {
				return c;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String majorInfo = ".." + name;
		for (Course c : courses) {
			majorInfo += "\n..." + c;
		}
		return majorInfo;
	}
	
}
