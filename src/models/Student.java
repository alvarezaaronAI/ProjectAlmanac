package models;

import main.Forum;
import main.RecomendationsAndModifications;
import structure.Department;
import structure.Major;
import structure.School;

public class Student extends User {
	/**
	 * Student Instances-What makes a student a student.
	 */
	Major major;
	Forum forum;
	RecomendationsAndModifications recsAndMods;
	CalendarModel calendar;
	
	/**
	 * Constructor-When creating a student you want to create a unique identity
	 */
	public Student(String firstNameIn, String lastNameIn, String emailIn, String passwordIn, String[] info) {
		super(firstNameIn, lastNameIn, emailIn, passwordIn);
		
		School school = determineSchool(info[0]);
		if (school != null) {
			Department dept = school.findDept(info[1]);
			if (dept != null) {
				major = dept.findMajor(info[2]);
			}
		}
	}
	/**
	 * Methods About the Student
	 */
	
	/*
	 * Accessors
	 */
	
	public Major getMajor() {
		return major;
	}
	
	public Forum getForum() {
		return forum;
	}
	
	public RecomendationsAndModifications getRecsAndMods() {
		return recsAndMods;
	}
	
	public CalendarModel getCalendar() {
		return calendar;
	}
	
	/*
	 * Mutators
	 */
	
	public void setMajor(Major major) {
		this.major = major;
	}
	
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	
	public void setRecsAndMods(RecomendationsAndModifications recsAndMods) {
		this.recsAndMods = recsAndMods;
	}
	
	public void setCalendarModel(CalendarModel calendar) {
		this.calendar = calendar;
	}
	
	
	/*
	 * To String
	 */
	@Override
	public String toString() {
		return "Student: " + super.toString(); 
	}	

}
