package structure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Major {

	private String name;
	private ArrayList<Course> courses = new ArrayList<>();
	
	/*
	 * Constructors
	 */
	
	public Major(String name) {
		this.name = name;
	}
	
	/*
	 * Accessors
	 */
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	/*
	 * Mutators
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	/*
	 * Others
	 */
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public void removeCourse(Course course) {
		courses.remove(course);
	}
	
	@Override
	public String toString() {
		String majorInfo = ".." + name;
		for (Course c : courses) {
			majorInfo += "\n..." + c;
		}
		return majorInfo;
	}
	
	
	public void getClasses()
	{
		
		Scanner inFile1;
		try {
			inFile1 = new Scanner(new File("CS Classes.txt"));

		StringBuilder sb = new StringBuilder();
		while(inFile1.hasNext()) 
		{
		    sb.append(inFile1.nextLine());
		}

		String[] yourArray = sb.toString().split(", ");

		for(int i = 0: i < yourArray.length; i++)
		{
			if(i%6 == 0)
			{
				deptArray.add = yourArray[i]
			}
		}
		   }
		catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }	
	
}
