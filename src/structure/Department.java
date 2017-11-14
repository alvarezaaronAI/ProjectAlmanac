package structure;

import java.util.ArrayList;

public class Department {

	private int id;
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
	
	public int getID() {
		return id;
	}
	
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
	
	public Major findMajor(int majorID) {
		for (Major m : majors) {
			if (m.getID() == majorID) {
				return m;
			}
		}
		return null;
	}
	
	public Major findMajor(String majorName) {
		for (Major m : majors) {
			if (m.getName().equals(majorName)) {
				return m;
			}
		}
		return null;
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
