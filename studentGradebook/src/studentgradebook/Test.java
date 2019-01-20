package studentgradebook;

public class Test implements java.io.Serializable {

	private String testName;
	private double testScore;
	private double testWeighting;
	
	public Test(String testName, double testScore, double testWeighting) {
		this.testName = testName;
		this.testScore = testScore;
		this.testWeighting = testWeighting;
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
        
        @Override
        public String toString() {
            return "This test is called:" + this.getTestName();
        }
}
