package studentgradebook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Course implements java.io.Serializable {

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
        
        public double weightSum() {
            
            double weightSum = 0.0;
            
            for(int i = 0; i < tests.size(); i++) {
                weightSum += this.tests.get(i).getTestWeighting() / 100;
            }
            
            for(int i = 0; i < assignments.size(); i++) {
                weightSum += this.assignments.get(i).getAssignWeighting() / 100;
            }
            
            return weightSum;
        }
        
        public double weightSumTests() {
            
            double weightSum = 0.0;
            
            for(int i = 0; i < tests.size(); i++) {
                weightSum += this.tests.get(i).getTestWeighting() / 100;
            }
            
            return weightSum;
        }
        
        public double weightSumAssignments() {
            
            double weightSum = 0.0;
            
            for(int i = 0; i < assignments.size(); i++) {
                weightSum += this.assignments.get(i).getAssignWeighting() / 100;
            }
            
            return weightSum;
        }
        
        public double classAverage(ArrayList tests, ArrayList assignments) {
            
            double weightedAvg = 0.0;
            
            for(int i = 0; i < tests.size(); i++) {
                weightedAvg += (this.tests.get(i).getTestWeighting() / 100) * this.tests.get(i).getTestScore();
            }
            
            for(int i = 0; i < assignments.size(); i++) {
                weightedAvg += (this.assignments.get(i).getAssignWeighting() / 100) * this.assignments.get(i).getAssignScore();
            }
            
            return weightedAvg / this.weightSum();
        }
        
        public void saveCourse() {
            try {
                FileOutputStream fileOut =
                new FileOutputStream("/tmp/" + this.getCourseName() + ".ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(this);
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in /tmp/" + this.getCourseName() + ".ser");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        @Override
        public String toString() {
            return "This course is called:" + this.getCourseName();
        }
}
