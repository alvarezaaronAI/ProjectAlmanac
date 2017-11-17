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
	
	/*
	 * Adds a major
	 * Returns false if a major already exists with the same name
	 */
	public boolean addMajor(Major major) {
		if (findMajor(major.getName()) == null) {
			return majors.add(major);
		}
		return false;
	}
	
	/*
	 * Removes a major
	 * Returns false if the major does not exist
	 */
	public boolean removeMajor(Major major) {
		return majors.remove(major);
	}
	
	/*
	 * Removes a major by name
	 * Returns false if the major does not exist
	 */
	public boolean removeMajor(String majorName) {
		for (int i = 0; i < majors.size(); i++) {
			if (majors.get(i).getName().equals(majorName)) {
				majors.remove(i);
				return true;
			}
		}
		return false;
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
