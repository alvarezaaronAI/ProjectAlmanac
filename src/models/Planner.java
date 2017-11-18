package models;

import java.util.ArrayList;

import structure.Course;
import structure.Department;
import structure.Major;
import structure.School;

public class Planner {
	
	private final int MAX_UNITS = 18;
	
	private ArrayList<Semester> recSchedule = new ArrayList<>();
	private ArrayList<Semester> customSchedule = new ArrayList<>();
	private ArrayList<Course> takenCourses = new ArrayList<>();
	private Major major;
	private Semester earliestSem;
	
	/*
	 * Constructors
	 */
	
	public Planner(String schoolName, String deptName, String majorName, String earliestSemName, int earliestYear) {
		School school = Global.findSchool(schoolName);
		Department dept = school.findDept(deptName);
		major = dept.findMajor(majorName);
		earliestSem = new Semester(earliestSemName, earliestYear);
		generateRecSchedule();
	}
	
	/*
	 * Accessors
	 */
	
	public ArrayList<Semester> getRecommendedSchedule() {
		return recSchedule;
	}
	
	public ArrayList<Semester> getCustomSchedule() {
		return customSchedule;
	}
	
	public ArrayList<Course> getTakenCourses() {
		return takenCourses;
	}
	
	public Major getMajor() {
		return major;
	}
	
	public Semester getEarliestSemester() {
		return earliestSem;
	}
	
	/*
	 * Mutators
	 */
	
	public void setRecommendedSchedule(ArrayList<Semester> recSchedule) {
		this.recSchedule = recSchedule;
	}
	
	public void setCustomSchedule(ArrayList<Semester> schedule) {
		this.customSchedule = schedule;
	}
	
	public void setTakenCourses(ArrayList<Course> takenCourses) {
		this.takenCourses = takenCourses;
	}
	
	public void setMajor(Major major) {
		this.major = major;
	}
	
	public void setEarliestSemester(Semester earliestSem) {
		this.earliestSem = earliestSem;
	}
	
	/*
	 * Methods for the recommended schedule
	 */
	
	/*
	 * Generates the recommended schedule based on the requirements for the major
	 * Custom schedule starts out the same as the recommended schedule
	 */
	private void generateRecSchedule() {
		ArrayList<Course> reqs = major.getCourses();
		int semInd = 0;
		for (Course c : reqs) {
			if (recSchedule.isEmpty()) {
				recSchedule.add(earliestSem);
			} else if (recSchedule.get(semInd).getUnits() > MAX_UNITS) {
				recSchedule.add(nextDefaultSemester(recSchedule.get(semInd)));
				semInd++;
			}
			boolean cleared = prereqsCleared(c, recSchedule.get(semInd));
			if (!takenCourses.contains(c) && cleared) {
				recSchedule.get(semInd).addCourse(c);
			}
			// brainstorming: if a prereq is not cleared, look for the prereq and add it first
			// make it a loop so that if the prereq has a prereq, you add that first and so on
		}
		copyRecSchedule();
	}
	
	/*
	 * Returns the next semester for a default schedule (either Fall or Spring)
	 */
	private Semester nextDefaultSemester(Semester sem) {
		String nextName = new String();
		int nextYear = 0;
		if (sem.getName().equals("Spring")) {
			nextName = "Fall";
			nextYear = sem.getYear();
		} else if (sem.getName().equals("Fall")) {
			nextName = "Spring";
			nextYear = sem.getYear() + 1;
		}
		return new Semester(nextName, nextYear);
	}
	
	/*
	 * Copies the recommended schedule into the custom schedule
	 * Overrides any elements the custom schedule has
	 */
	private void copyRecSchedule() {
		if (!customSchedule.isEmpty()) {
			customSchedule = new ArrayList<>();
		}
		for (Semester s : recSchedule) {
			customSchedule.add(s.copy());
		}
	}
	
	/*
	 * Methods for the custom schedule
	 */
	
	/*
	 * Adds course to student schedule
	 * Returns false if: already added, already taken, non-cleared prereqs, over unit limit,
	 * or not offered for that semester
	 */
	public boolean addCourse(Course course, String semesterName, int year) {
		Semester sem = findSemester(semesterName, year);
		if (sem == null) {
			sem = new Semester(semesterName, year);
		}
		if (course.isOffered(semesterName) && sem.getUnits() < MAX_UNITS
				&& !sem.hasCourse(course) && !takenCourses.contains(course)
				&& prereqsCleared(course, sem)) {
			sem.addCourse(course);
			customSchedule.add(sem);
		}
		return false;
	}
	
	/*
	 * Removes course from student schedule
	 * Returns false if no such course was found in the given semester
	 */
	public boolean removeCourse(Course course, String semesterName, int year) {
		Semester sem = findSemester(semesterName, year);
		if (sem != null && sem.removeCourse(course)) {
			if (sem.isEmpty()) {
				customSchedule.remove(sem);
			}
			return true;
		}
		return false;
		// IMPORTANT: Removing a course could lead to having a schedule where you haven't met the prereqs
	}
	
	/*
	 * Finds the semester in the custom schedule with the given name and year
	 */
	private Semester findSemester(String semesterName, int year) {
		for (Semester s : customSchedule) {
			if (s.getName().equals(semesterName) && s.getYear() == year) {
				return s;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String str = new String();
		for (Semester s : customSchedule) {
			str += s + "\n";
		}
		return str;
	}
	
	/*
	 * Methods for both the recommended and custom schedule
	 */
	
	/*
	 * Returns true if there are no prereq conflicts for the given semester
	 */
	private boolean prereqsCleared(Course course, Semester currentSem) {
		return prereqsNeeded(course, currentSem).isEmpty();
	}
	
	/*
	 * Returns a list of prereqs that have not been taken care of
	 */
	public ArrayList<Course> prereqsNeeded(Course course, Semester currentSem) {
		ArrayList<Course> needed = new ArrayList<>();
		for (Course pre : course.getPrereqs()) {
			if (!takenCourses.contains(pre) && !courseInPrevSems(course, currentSem)) {
				needed.add(pre);
			}
		}
		return needed;
	}
	
	/*
	 * Returns true if the given course has been added to any semester before the given semester
	 */
	private boolean courseInPrevSems(Course course, Semester currentSem) {
		for (int i = 0; customSchedule.get(i).compareTo(currentSem) < 0; i++) {
			if (customSchedule.get(i).hasCourse(course)) {
				return true;
			}
		}
		return false;
	}

}
