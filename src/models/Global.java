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
	private File defaultFile = new File("DataBase/CSULA.txt"); // CSULA data file
	private School defaultSchool; // CSULA

	/*
	 * Constructors
	 */

	public Global() {
	}

	public Global(ArrayList<User> users) throws FileNotFoundException {
		setUsers(users);

		// make default database for CSULA
		defaultSchool = generateSchool(defaultFile);
		databases.add(defaultSchool);
	}

	public Global(ArrayList<User> users, ArrayList<File> databasesFile) throws FileNotFoundException {
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

	public School generateSchool(File schoolFile) throws FileNotFoundException {
		// Levi's work goes here

		School tempSchool = new School(null);
		Department dept = new Department(null);
		Major major = new Major(null);
		File file = schoolFile;
		System.out.println(file.getAbsolutePath());
		int index = 0;
		try {
			String line = null;
			BufferedReader br = new BufferedReader(new FileReader(file));
			//String text = null;
			while ((line = br.readLine()) != null) {
				System.out.println("Text File : " + line);
				if (index == 0) {
					tempSchool = new School(line);
					System.out.println("First Line 0: " + tempSchool.getName());
					index++;
				} else if (index == 1) {
					// String [] depts = line.split(", ");
					// for (int i = 0; i < depts.length; i++)
					// {
					dept = new Department(line);
					System.out.println("Second Line 1:" + dept.getName());
					tempSchool.addDept(dept);
					// }
					index++;
				} else if (index == 2) {
					major = new Major(line);
					dept.addMajor(major);
					System.out.println("Major is " + major.getName());
					System.out.println("Department for that major " + dept.getName());
					index++;
				} else {
					{
						String classes[] = line.split(", ");
						String dept1 = classes[0];
						System.out.println("**Dept:" + dept1);
						int number = Integer.parseInt(classes[1]);
						System.out.println("**number:" + number);
						String name = classes[2];
						System.out.println("**name:" + name);
						int units = Integer.parseInt(classes[3]);
						System.out.println("**units:" + units);
						String prereq = classes[4];
						System.out.println("**prereq:" + prereq);

						String semesters = classes[5];
						String[] semesterSplit = semesters.split("--");
						ArrayList<String> semesterNow = new ArrayList<>();
						for (int j = 0; j < semesterSplit.length; j++) {
							semesterNow.add(semesterSplit[j]);
							System.out.println("**semester " + semesterNow.get(j));
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
			System.out.println("Name of the school :" +tempSchool.getName());
			//Test 2 checking all the deparments of that school
			for (int i = 0; i < tempSchool.getDepts().size(); i++) {
				Department tempDept = tempSchool.getDepts().get(i);
				System.out.println("--Deparment " + i + "is " + tempDept.getName());
				//Test 3 checking for a major under every departments
				for (int j = 0; j < tempDept.getMajors().size(); j++) {
					Major tempMajor = tempDept.getMajors().get(j);
					System.out.println("---Major for this dept is " + tempMajor.getName());
				}
			}
			this.defaultSchool = tempSchool;
			System.out.println(this.defaultSchool.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
	public static void main(String[] args) throws FileNotFoundException {
		Global test1 = new Global();
		ArrayList<User> students = new ArrayList<User>(); // -- harry -joe
		String[] info1 = new String[3];
		info1[0] = "CSULA";
		info1[1] = "Engr";
		info1[2] = "Computer Science";
		String[] info2 = new String[3];
		info2[0] = "CSULA";
		info2[1] = "Engr";
		info2[2] = "Computer Science";
		students.add(new Student("harry", "potter", "h@p.com", "asdf", info1));
		students.add(new Student("joe", "low", "j@l.com", "ghjk", info2));
		for (int i = 0; i < students.size(); i++) {
			System.out.println("Student " + i + " is -" + students.get(i).getFirstName());
		}
		// Add the students to the application scope (Servlet Context)
		Global mainDB = new Global(students);
		//Test 1 Checking for Name of school was entered
		System.out.println("Name of the school :" +mainDB.defaultSchool.getName());
		//Test 2 checking all the deparments of that school
		for (int i = 0; i < mainDB.defaultSchool.getDepts().size(); i++) {
			Department tempDept = mainDB.defaultSchool.getDepts().get(i);
			System.out.println("--Deparment " + i + "is " + tempDept.getName());
			//Test 3 checking for a major under every departments
			for (int j = 0; j < tempDept.getMajors().size(); j++) {
				Major tempMajor = tempDept.getMajors().get(j);
				System.out.println("---Major for this dept is " + tempMajor.getName());
			}
		}
		
	}
}