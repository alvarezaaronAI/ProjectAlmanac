package models;

import java.util.ArrayList;

import structure.Course;

public class Semester implements Comparable<Semester> {

	private String name; // Fall/Winter/Spring/Summer
	private int year;
	private int units;
	private ArrayList<Course> courses = new ArrayList<>();
	
	public Semester(String name, int year) {
		this.name = name;
		this.year = year;
	}
	
	public String getName() {
		return name;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getUnits() {
		return units;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public boolean addCourse(Course course) {
		if (courses.add(course)) {
			units += course.getUnits();
			return true;
		}
		return false;
	}
	
	public boolean removeCourse(Course course) {
		if (courses.remove(course)) {
			units -= course.getUnits();
			return true;
		}
		return false;
	}
	
	public boolean hasCourse(Course course) {
		return courses.contains(course);
	}
	
	public boolean isEmpty() {
		return courses.isEmpty();
	}
	
	public Semester copy() {
		Semester copy = new Semester(name, year);
		copy.units = units;
		ArrayList<Course> copyCourses = new ArrayList<>();
		for (Course c : courses) {
			copyCourses.add(c);
		}
		return copy;
	}

	@Override
	public int compareTo(Semester other) {
		if (year != other.year) { // compare years
			return year - other.year;
		} else { // compare semesters
			if (name.equals(other.name)) {
				return 0;
			} else if (name.equals("Spring")) {
				return -1;
			} else if (other.name.equals("Spring")) {
				return 1;
			} else if (name.equals("Summer")) {
				return -1;
			} else if (other.name.equals("Summer")) {
				return 1;
			} else if (name.equals("Fall")) {
				return -1;
			} else {
				return 1;
			}
		}
	}
	
	@Override
	public String toString() {
		String str = name + " " + year;
		for (Course c : courses) {
			str += "\n-" + c;
		}
		return str;
	}
}
