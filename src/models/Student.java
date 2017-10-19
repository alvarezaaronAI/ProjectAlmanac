package models;

public class Student extends User {
	/**
	 * Student Instances-What makes a student a student.
	 * No new instances beyond User
	 */

	/*What does every student have-At A time access to all
		Add Forum here
		RecomendationsAndModifications
		Add Calendar
	*/
	/**
	 * Constructor-When creating a student you want to create a unique identity
	 */
	public Student(String firstNameIn, String lastNameIn, String emailIn, String passwordIn) {
		super(firstNameIn, lastNameIn, emailIn, passwordIn);
	}
	/**
	 * Methods About the Student
	 */
	
	
	/*
	 * To String
	 */
	@Override
	public String toString() {
		return "Student: " + super.toString(); 
	}
	/**
	 * Main Method that allows me to test out quickly some methods.
	 */
	public static void main(String[] args) {
		Student x = new Student("Aaron", "Alvarez", "aalva190@gmail.com", "abcd");
		System.out.println(x);
		Student y = new Student("Aaron", "Alvarez", "aalva191@gmail.com", "abcd");
		System.out.println(y);
		System.out.println(x.uniqueIden().compareTo(y.getIdentity()) == 0);
		Student z = new Student("Aaron", "Alvarez", "aalva192@gmail.com", "abcd");
		System.out.println(z);
		System.out.println(x.uniqueIden().compareTo(z.getIdentity()) == 0);
		System.out.println(y.uniqueIden().compareTo(z.getIdentity()) == 0);
	}
	

}
