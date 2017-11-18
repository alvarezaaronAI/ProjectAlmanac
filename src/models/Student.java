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
	Planner planner; // has both recommended and custom schedules
	
	/**
	 * Constructor-When creating a student you want to create a unique identity
	 */
	public Student(String firstNameIn, String lastNameIn, String emailIn, String passwordIn, String[] info) {
		super(firstNameIn, lastNameIn, emailIn, passwordIn);
		
		School school = Global.findSchool(info[0]);
		if (school != null) {
			Department dept = school.findDept(info[1]);
			if (dept != null) {
				major = dept.findMajor(info[2]);
			}
		}
		this.planner = new Planner("California State University of Los Angeles", "Engineering", "Computer Science", "Fall", 2018);
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
	
	public Planner getPlanner() {
		return planner;
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
	
	public void setPlanner(Planner planner) {
		this.planner = planner;
	}
	
	
	/*
	 * To String
	 */
	@Override
	public String toString() {
		return "Student: " + super.toString(); 
	}	

}