package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import structure.Course;
import structure.Department;
import structure.Major;
import structure.School;

public class Global {

	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Student> students = new ArrayList<>();
	public static ArrayList<Faculty> faculty = new ArrayList<>();
	public static ArrayList<School> databases = new ArrayList<>();
	private ArrayList<File> databasesFile = new ArrayList<>();
	private File defaultFile = new File("name goes here"); // CSULA data file
	private School defaultSchool; // CSULA

	/*
	 * Constructors
	 */

	public Global() {
	}

	public Global(ArrayList<User> users) {
		setUsers(users);

		// make default database for CSULA
		defaultSchool = generateSchool(defaultFile);
		databases.add(defaultSchool);
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

	public School generateSchool(File schoolFile) {
		// Levi's work goes here

		School tempSchool = new School(null);
		Department dept = new Department(null);
		Major major = new Major(null);
		File file = new File("Users\\Levi\\Desktop\\CS Classes.txt");
		BufferedReader reader = null;
		int index = 0;
		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;
			while ((text = reader.readLine()) != null) {
				String line = reader.readLine();
				if (index == 0) {
					line = reader.readLine();
					tempSchool = new School(line);
					index++;
				} else if (index == 1) {
					line = reader.readLine();
					// String [] depts = line.split(", ");
					// for (int i = 0; i < depts.length; i++)
					// {
					dept = new Department(line);
					tempSchool.addDept(dept);
					// }
					index++;
				} else if (index == 2) {
					line = reader.readLine();
					major = new Major(line);
					dept.addMajor(major);
					index++;
				} else {
					{
						String classes[] = reader.readLine().split(", ");
						String dept1 = classes[0];
						int number = Integer.parseInt(classes[1]);
						String name = classes[2];
						int units = Integer.parseInt(classes[3]);
						String prereq = classes[4];

						String semesters = classes[5];
						String[] semesterSplit = semesters.split("*");
						ArrayList<String> semesterNow = new ArrayList<>();
						for (int j = 0; j < semesterSplit.length; j++) {
							semesterNow.add(semesterSplit[j]);
						}

						if (prereq.matches("none")) {
							Course course = new Course(dept1, number, name, units, semesterNow);
							course.setPrereqs(null);
						} else {
							ArrayList<Course> preR = new ArrayList<>();
							String[] prereqCourse = prereq.split("-");

							for (int i = 0; i < prereqCourse.length; i++) {
								String string = prereqCourse[i];
								Course tempCourse = new Course(dept1, number);
								preR.add(tempCourse);
							}

							Course course = new Course(dept1, number, name, units, semesterNow);
							course.setPrereqs(preR);
						}
					}

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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