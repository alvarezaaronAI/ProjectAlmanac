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
	
	/*
	 * Adds a course
	 * Returns false if a course already exists with the same name
	 */
	public boolean addCourse(Course course) {
		if (findCourse(course.getName()) == null) {
			return courses.add(course);
		}
		return false;
	}
	
	/*
	 * Removes a course
	 * Returns false if the course does not exist
	 */
	public boolean removeCourse(Course course) {
		return courses.remove(course);
	}
	
	/*
	 * Removes a course by ID
	 * Returns false if the course does not exist
	 */
	public boolean removeCourse(String courseID) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getID().equals(courseID)) {
				courses.remove(i);
				return true;
			}
		}
		return false;
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
