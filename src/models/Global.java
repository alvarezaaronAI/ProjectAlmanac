package models;

import java.io.File;
import java.util.ArrayList;

import structure.School;

public class Global {

	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Student> students = new ArrayList<>();
	public static ArrayList<Faculty> faculty = new ArrayList<>();
	public static ArrayList<School> databases = new ArrayList<>();
	private ArrayList<File> databasesFiles = new ArrayList<>();
	private File defaultFile = new File("name goes here"); // CSULA data file
	private School defaultSchool; // CSULA
	
	/*
	 * Constructors
	 */
	
	public Global() {}
	
	public Global(ArrayList<User> users) {
		setUsers(users);
		
		// make default database for CSULA
		defaultSchool = generateSchool(defaultFile);
		databases.add(defaultSchool);
	}
	
	public Global(ArrayList<User> users, ArrayList<File> databasesFile) {
		setUsers(users);
		
		this.databasesFiles = databasesFile;
		for (File f : databasesFile) {
			databases.add(generateSchool(f));
		}
	}
	
	/*
	 * Accessors
	 */
	
	public ArrayList<File> getDatabasesFile() {
		return databasesFiles;
	}
	
	public File getDefaultFile() {
		return defaultFile;
	}
	
	public School defaultSchool() {
		return defaultSchool;
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
	
	public void setDatabasesFile(ArrayList<File> databasesFile) {
		this.databasesFiles = databasesFile;
	}
	
	public void setDefaultFile(File defaultFile) {
		this.defaultFile = defaultFile;
	}
	
	public void setDefaultSchool(School defaultSchool) {
		this.defaultSchool = defaultSchool;
	}
	
	/*
	 * More
	 */
	
	public School generateSchool(File schoolFile) {
		// Levi's work goes here
		return null;
	}
	
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
	
	public static School findSchool(String name) {
		for (School s : databases) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}
}
