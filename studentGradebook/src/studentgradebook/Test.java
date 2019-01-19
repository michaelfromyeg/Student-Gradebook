package studentgradebook;

public class Test {

	private String testName;
	private double testScore;
	private double testWeighting;
	private Course course;
	
	public Test(String testName, double testScore, double testWeighting, Course course) {
		this.testName = testName;
		this.testScore = testScore;
		this.testWeighting = testWeighting;
		this.course = course;
	}
	
	public String getTestName() {
		return this.testName;
	}
	
	public void setTestName(String newTestName) {
		this.testName = newTestName;
	}
	
	public double getTestScore() {
		return this.testScore;
	}
	
	public void setTestScore(double newTestScore) {
		this.testScore = newTestScore;
	}
	
	public double getTestWeighting() {
		return this.testWeighting;
	}
	
	public void setTestWeighting(double newTestWeighting) {
		this.testWeighting = newTestWeighting;
	}
	
	public Course getCourse() {
		return this.course;
	}
	
	public void setCourse(Course newCourse) {
		this.course = newCourse;
	}
	
	
}
