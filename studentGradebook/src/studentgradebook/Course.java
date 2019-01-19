package studentgradebook;

import java.util.ArrayList;

public class Course {

	private String courseName;
	private String location;
	private String teacher;
	public ArrayList<Test> tests = new ArrayList<Test>();
	public ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	
	public Course(String courseName, String location, String teacher) {
		this.courseName = courseName;
		this.location = location;
		this.teacher = teacher;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public void setCourseName(String newCourseName) {
		this.courseName = newCourseName;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(String newLocation) {
		this.location = newLocation;
	}

	public String getTeacher() {
		return this.teacher;
	}
	
	public void setTeacher(String newTeacher) {
		this.teacher = newTeacher;
	}
	
}
