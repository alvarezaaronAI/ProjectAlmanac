package structure;

import java.util.ArrayList;

public class Major {

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
	
	@Override
	public String toString() {
		String majorInfo = ".." + name;
		for (Course c : courses) {
			majorInfo += "\n..." + c;
		}
		return majorInfo;
	}
	
}
