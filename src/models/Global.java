package models;

import java.io.File;
import java.util.ArrayList;

import structure.School;

public class Global {

	public static ArrayList<User> users;
	public static ArrayList<Student> students;
	public static ArrayList<Faculty> faculty;
	public static ArrayList<School> databases = new ArrayList<>();
	private ArrayList<File> databasesFile;
	private File defaultFile = new File("name goes here"); // csula
	
	/*
	 * Constructors
	 */
	
	public Global() {}
	
	public Global(ArrayList<User> users) {
		setUsers(users);
		
		// make default database for csula
		School csula = generateSchool(defaultFile);
		databases.add(csula);
	}
	
	public Global(ArrayList<User> users, ArrayList<File> databasesFile) {
		setUsers(users);
		
		this.databasesFile = databasesFile;
		for (File f : databasesFile) {
			databases.add(generateSchool(f));
		}
	}
	
	/*
	 * Accessors
	 */
	
	public ArrayList<File> getDatabasesFile() {
		return databasesFile;
	}
	
	public File getDefaultFile() {
		return defaultFile;
	}
	
	/*
	 * Mutators
	 */
	
	public void setUsers(ArrayList<User> users) {
		Global.users = users;
		for (User u : users) {
			if (u instanceof Student) {
				students.add((Student) u);
			} else if (u instanceof Faculty) {
				faculty.add((Faculty) u);
			}
		}
	}
	
	/*
	 * More
	 */
	
	public void addUser(User user) {
		users.add(user);
		if (user instanceof Student) {
			students.add((Student) user);
		} else if (user instanceof Faculty) {
			faculty.add((Faculty) user);
		}
	}
	
	public void removeUser(User user) {
		users.remove(user);
		if (user instanceof Student) {
			students.remove((Student) user);
		} else if (user instanceof Faculty) {
			faculty.remove((Faculty) user);
		}
	}
	
	public School generateSchool(File schoolFile) {
		// Levi's work goes here
		return null;
	}
}
