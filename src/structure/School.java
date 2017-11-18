package structure;

import java.util.ArrayList;

public class School {

	private int id;
	private String name;
	private ArrayList<Department> depts = new ArrayList<>();
	
	/*
	 * Constructors
	 */
	public School() {
		
	}
	public School(String name) {
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
	
	/*
	 * Adds a department
	 * Returns false if a department already exists with the same name
	 */
	public boolean addDept(Department dept) {
		if (findDept(dept.getName()) == null) {
			return depts.add(dept);
		}
		return false;
	}
	
	/*
	 * Removes a department
	 * Returns false if the department does not exist
	 */
	public boolean removeDept(Department dept) {
		return depts.remove(dept);
	}
	
	/*
	 * Removes a department by name
	 * Returns false if the department does not exist
	 */
	public boolean removeDept(String deptName) {
		for (int i = 0; i < depts.size(); i++) {
			if (depts.get(i).getName().equals(deptName)) {
				depts.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Department findDept(int deptID) {
		for (Department d : depts) {
			if (d.getID() == deptID) {
				return d;
			}
		}
		return null;
	}
	
	public Department findDept(String deptName) {
		for (Department d : depts) {
			if (d.getName().equals(deptName)) {
				return d;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String schoolInfo = new String(name);
		for (Department d : depts) {
			schoolInfo += "\n" + d;
		}
		return schoolInfo;
	}
}
