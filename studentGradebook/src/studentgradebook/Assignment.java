package studentgradebook;

import java.util.Date;

public class Assignment {

	private String assignName;
	private double assignScore;
	private double assignWeighting;
	private Course course;
        private Date date;
	
	public Assignment(String assignName, double assignScore, double assignWeighting, Course course, Date date) {
		this.assignName = assignName;
		this.assignScore = assignScore;
		this.assignWeighting = assignWeighting;
		this.course = course;
                this.date = date;
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
        
        public Date getDate() {
            return this.date;
        }
        
        public void setDate(Date newDate) {
            this.date = newDate;
        }
        
        @Override
        public String toString() {
            return "This assignment is called:" + this.getAssignName();
        }
}
