package structure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Major {
	public static void main(String [] args) {
		getClasses();
	}
	private int id;
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
	
	public int getID() {
		return id;
	}
	
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
	
	/*
	 * Adds a course
	 * Returns false if a course already exists with the same name
	 */
	public boolean addCourse(Course course) {
		if (findCourse(course.getName()) == null) {
			return courses.add(course);
		}
		return false;
	}
	
	/*
	 * Removes a course
	 * Returns false if the course does not exist
	 */
	public boolean removeCourse(Course course) {
		return courses.remove(course);
	}
	
	/*
	 * Removes a course by name
	 * Returns false if the course does not exist
	 */
	public boolean removeCourse(String courseName) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getName().equals(courseName)) {
				courses.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Course findCourse(String courseID) {
		for (Course c : courses) {
			if (c.getID().equals(courseID)) {
				return c;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String majorInfo = ".." + name;
		for (Course c : courses) {
			majorInfo += "\n..." + c;
		}
		return majorInfo;
	}
	
	
	public static void getClasses()
	{
		
		 ArrayList<String> schoolLines = new ArrayList<String>();
		 ArrayList<School> school = new ArrayList<>();
	        File file = new File("C:\\Users\\Levi\\Desktop\\CS Classes.txt");
	        BufferedReader reader = null;

	        try
	        {
	            reader = new BufferedReader(new FileReader(file));
	            String text = null;
	            int index = 0;
	            while ((text = reader.readLine()) != null)
	            {
	            		String line = reader.readLine();          
	      //      		System.out.println(schoolLines.add(line));
	                   String linev2 = schoolLines.get(index);
	                 String [] getNames =  linev2.split(",");
	                 System.out.println(getNames[0]); 
	                    
	                    // add to list
	     //                System.out.println(getName());
	                     
	                
	                 	index++;
	            }
	        } catch (FileNotFoundException e)
	        {
	            e.printStackTrace();
	        } catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        try
	        {
	            reader.close();
	        } catch (IOException e)
	        {
	            e.printStackTrace();
	        }
		/*
		Scanner inFile1;
		try 
		{
			inFile1 = new Scanner(new File("CS Classes.txt"));

		StringBuilder sb = new StringBuilder();
		while(inFile1.hasNext()) 
			{
				sb.append(inFile1.nextLine());
			}

		String[] yourArray = sb.toString().split(", ");
		ArrayList<Course> course = new ArrayList();

		for(int i = 0; i < yourArray.length; i++)
			{
				String deptArray;
				int courseNum;
				String name;
				int units;
				String prereqsClasses;
				String semester;
			
				ArrayList<Course> prereqs = new ArrayList();
				
				if(i%6 == 0)
					{
						deptArray = yourArray[i];
					}
				else if(i%6 == 1)
					{
						courseNum = Integer.parseInt(yourArray[i]);
					}
				else if(i%6 == 2)
					{
						name = yourArray[i];
					}
				else if(i%6 == 3)
					{
						units = Integer.parseInt(yourArray[i]);
					}
				else if(i%6 == 5)
				   {	 
						String[] subArray = sb.toString().split(" ");
							for(int j = 0; j < subArray.length; j++)
								{
									prereqsClasses = subArray[i];
									
									for(int k = 0; k < course.size(); k++)
									{
										if(course.get(k).getID().equals(prereqsClasses))
										{
											prereqs.add(course.get(k));
											break;
										}
									}
									
								}
					}
				else if(i%6 == 6)
					{
						String[] subArray = sb.toString().split(" ");
					}
			  }
		}
		catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }	
	*/
		
	}
}


