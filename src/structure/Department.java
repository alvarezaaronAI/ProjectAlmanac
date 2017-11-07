package structure;

import java.util.ArrayList;

public class Department {

	private String name;
	private ArrayList<Major> majors = new ArrayList<>();
	
	/*
	 * Constructors
	 */
	
	public Department(String name) {
		this.name = name;
	}
	
	/*
	 * Accessors
	 */
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Major> getMajors() {
		return majors;
	}
	
	/*
	 * Mutators
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMajors(ArrayList<Major> majors) {
		this.majors = majors;
	}
	
	/*
	 * Others
	 */
	
	public void addMajor(Major major) {
		majors.add(major);
	}
	
	public void removeMajor(Major major) {
		majors.remove(major);
	}
	
	@Override
	public String toString() {
		String deptInfo = "." + name;
		for (Major m : majors) {
			deptInfo += "\n" + m;
		}
		return deptInfo;
	}
}
