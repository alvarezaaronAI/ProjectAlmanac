package models;

import java.math.BigInteger;
import java.nio.charset.Charset;

public class Student {
	/**
	 * Student Instances-What makes a student a student.
	 */
	private BigInteger identy;
	private String firstName,lastName;
	private String email,password;
	/*What does every student have-At A time access to all
		Add Forum here
		RecomendationsAndModifications
		Add Calendar
	*/
	/**
	 * Constructor-When creating a student you want to create a unique identity
	 */
	public Student(String firstNameIn, String lastNameIn, String emailIn, String passwordIn) {
		this.firstName = firstNameIn;
		this.lastName = lastNameIn;
		this.email = emailIn;
		this.password = passwordIn;
		this.identy = uniqueIden();	
	}
	/**
	 * Methods About the Student
	 */
	/*
	 * Creating Method that gives me a unique indentity based on the students information
	 * We create the this given the students last name and email.
	 */
	private BigInteger uniqueIden() {
		BigInteger lastname = getNumberId(this.lastName);
		BigInteger email = getNumberId(this.email);
		BigInteger uniqueKey = lastname.add(email);
		return uniqueKey;
		
	}
	/*
	 * Returns a big integer that was convereted from a string into a a big integer.
	 */
	public static BigInteger getNumberId(String value) {
	    return new BigInteger(value.getBytes(Charset.availableCharsets().get("UTF-8")));
	}
	/**
	 * Getters And Setters
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	public BigInteger getIdenty() {
		return identy;
	}
	public void setIdenty(BigInteger identy) {
		this.identy = identy;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*
	 * To String
	 */
	@Override
	public String toString() {
		return "Students- " + getFullName() + " Email- " + getEmail() +" UniqueIdentity-" + getIdenty();
	}
	/**
	 * Main Method that allows me to test out quickly some methods.
	 */
	public static void main(String[] args) {
		Student x = new Student("Aaron", "Alvarez", "aalva190@gmail.com", "abcd");
		System.out.println(x);
		Student y = new Student("Aaron", "Alvarez", "aalva191@gmail.com", "abcd");
		System.out.println(y);
		System.out.println(x.uniqueIden().compareTo(y.getIdenty()) == 0);
		Student z = new Student("Aaron", "Alvarez", "aalva192@gmail.com", "abcd");
		System.out.println(z);
		System.out.println(x.uniqueIden().compareTo(z.getIdenty()) == 0);
		System.out.println(y.uniqueIden().compareTo(z.getIdenty()) == 0);
	}
	

}
