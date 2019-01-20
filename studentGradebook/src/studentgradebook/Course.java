package studentgradebook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Course implements java.io.Serializable {

	public String courseName;
	public String location;
	public String teacher;
	public ArrayList<Test> tests = new ArrayList<>();
        
	public Course(String courseName, String location, String teacher) {
            this.courseName = courseName;
            this.location = location;
            this.teacher = teacher;
            this.tests = new ArrayList<>();
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
            this.tests.add(test);
        }
        
        public int getTestNum() {
            return tests.size();
            
        }
        
        public Test getTest(int index) {
            return tests.get(index);
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
 
        public double weightSum() { 
            double weightSum = 0.0;
            
            for(int i = 0; i < tests.size(); i++) {
                weightSum += this.tests.get(i).getTestWeighting() / 100;
            }            
            return weightSum;
        }
        
        public double classAverage(double mark, double weight) { // Method for one extra mark
            double weightedAvg = 0.0;
            
            for(int i = 0; i < tests.size(); i++) {
                weightedAvg += (this.tests.get(i).getTestWeighting() / 100) * this.tests.get(i).getTestScore();
            }
            System.out.println(weightedAvg);
            return (weightedAvg + ((weight / 100) * mark)) / (this.weightSum() + (weight / 100));
            
        }
        
        public double classAverage() {     
            double weightedAvg = 0.0;
            
            for(int i = 0; i < tests.size(); i++) {
                weightedAvg += (this.tests.get(i).getTestWeighting() / 100) * this.tests.get(i).getTestScore();
            }
            return weightedAvg / this.weightSum();
        }
        
        @Override
        public String toString() {
            return "This course is called: " + this.getCourseName();
        }
}
