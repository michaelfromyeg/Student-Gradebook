package studentgradebook;

import java.util.ArrayList;

public class Course {

	private String courseName;
	private String location;
	private String teacher;
	private static ArrayList<Test> tests = new ArrayList<Test>();
	private static ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	
	public Course(String courseName, String location, String teacher) {
            this.courseName = courseName;
            this.location = location;
            this.teacher = teacher;
            Course.tests = new ArrayList<>();
            Course.assignments = new ArrayList<>();
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
	
        public void addTest(Test test) {
            tests.add(test);
        }
        
        public void deleteTest(Test test) {
            int index = tests.indexOf(test);
                if (index == -1) {
                    System.out.print("Test not found!");
                }
                else {
                    tests.remove(index);
                }
        }
        
        public void addAssignment(Assignment assign) {
            assignments.add(assign);
        }
        
        public void deleteAssignment(Assignment assign) {
            int index = assignments.indexOf(assign);
                if (index == -1) {
                    System.out.print("Assignment not found!");
                }
                else {
                    assignments.remove(index);
                }
        }
        
        public double classAverage(ArrayList tests, ArrayList assignments) {
            for(int i = 0; i < tests.size(); i++) {
                this.tests.get(i).getTestWeighting();
            }
            
            for(int i = 0; i < tests.size(); i++) {
                this.tests.get(i).getTestWeighting();
            }
            return 0;
        }
        
        @Override
        public String toString() {
            return "This course is called:" + this.getCourseName();
        }
}
