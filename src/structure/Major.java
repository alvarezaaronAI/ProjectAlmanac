package structure;

import java.util.ArrayList;

public class Major {

	private String name;
	private ArrayList<Course> courses;
	
	public Major(String name) {
		this.name = name;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
}
