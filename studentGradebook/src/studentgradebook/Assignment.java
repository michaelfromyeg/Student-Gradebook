package studentgradebook;

public class Assignment {

	private String assignName;
	private double assignScore;
	private double assignWeighting;
	private Course course;
	
	public Assignment(String assignName, double assignScore, double assignWeighting, Course course) {
		this.assignName = assignName;
		this.assignScore = assignScore;
		this.assignWeighting = assignWeighting;
		this.course = course;
	}
	
	public String getAssignName() {
		return this.assignName;
	}
	
	public void setAssignName(String newAssignName) {
		this.assignName = newAssignName;
	}
	
	public double getAssignScore() {
		return this.assignScore;
	}
	
	public void setAssignScore(double newAssignScore) {
		this.assignScore = newAssignScore;
	}
	
	public double getAssignWeighting() {
		return this.assignWeighting;
	}
	
	public void setAssignWeighting(double newAssignWeighting) {
		this.assignWeighting = newAssignWeighting;
	}
	
	public Course getCourse() {
		return this.course;
	}
	
	public void setCourse(Course newCourse) {
		this.course = newCourse;
	}
	
}
