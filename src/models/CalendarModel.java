package models;

import java.util.ArrayList;

import structure.School;

public class CalendarModel {
	private School csula = new School("California State Universtiy Los Angeles");
	private School genericSchool;
	private ArrayList<School> schools;
	//Constructor that adds CSULA as a school as default.
	public CalendarModel() {
		this.schools.add(csula);
	}
	//Constructor that allows the user to create its own school.
	public CalendarModel(String schoolName) {
		this.genericSchool = new School(schoolName);
		this.schools.add(csula);
		this.schools.add(genericSchool);

	}
	// Methods that will allow me to update school.
	private void addSchool() {
		// add a specific school

	}
	public void addDept() {
		//add dept to a specific School
	}
	public void addMajor() {
		// add major to a specific Dept

	}
	public void addCourse() {
		// add a specific course to a specific major

	}
	//.... Add more methods that allows me to create a fully functional school that i can mess with, 
	/*
	 * CSULA was created at the top, create a method that will run in the default constructor, that will
	 * add all the courses manually for CSULA. SO CSULA should have be ready to run when use the default constructor.
	 * */
	
	// Getters and Setters

	public School getCsula() {
		return csula;
	}

	public void setCsula(School csula) {
		this.csula = csula;
	}

	public School getGenericSchool() {
		return genericSchool;
	}

	public void setGenericSchool(School genericSchool) {
		this.genericSchool = genericSchool;
	}

	public ArrayList<School> getSchools() {
		return schools;
	}

	public void setSchools(ArrayList<School> schools) {
		this.schools = schools;
	}

}
