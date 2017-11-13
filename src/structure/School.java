package structure;

import java.util.ArrayList;

public class School {

	private String name;
	private ArrayList<Department> depts = new ArrayList<>();
	
	/*
	 * Constructors
	 */
	
	public School(String name) {
		this.name = name;
	}
	
	/*
	 * Accessors
	 */
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Department> getDepts() {
		return depts;
	}
	
	/*
	 * Mutators
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDepts(ArrayList<Department> depts) {
		this.depts = depts;
	}
	
	/*
	 * Others
	 */
	
	public void addDept(Department dept) {
		depts.add(dept);
	}
	
	public void removeDept(Department dept) {
		depts.remove(dept);
	}
	
	@Override
	public String toString() {
		String schoolInfo = new String(name);
		for (Department d : depts) {
			schoolInfo += "\n" + d;
		}
		return schoolInfo;
	}
	
	// TESTING
	public static void main(String[] args) {
		School csula = new School("CSULA");
		Department eng = new Department("Engineering");
		Major cs = new Major("Computer Science");
		ArrayList<String> semesters = new ArrayList<>();
		semesters.add("Fall");
		semesters.add("Spring");
		Course cs3337 = new Course("CS", 3337, "Software Engineering", 3, semesters);
		Course cs3112 = new Course("CS", 3112, "Analysis of Algorithms", 3, semesters);
		csula.addDept(eng);
		eng.addMajor(cs);
		cs.addCourse(cs3337);
		cs.addCourse(cs3112);

		System.out.println(csula);
	}
}
