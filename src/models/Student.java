package models;

import main.Calendar;
import main.Forum;
import main.RecomendationsAndModifications;

public class Student extends User {
	/**
	 * Student Instances-What makes a student a student.
	 */
	Forum forum;
	RecomendationsAndModifications recsAndMods;
	CalendarModel calendar;
	
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
	 * Accessors
	 */
	
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