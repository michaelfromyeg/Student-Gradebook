/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentgradebook;

/**
 *
 * @author Michael DeMarco, Jordan Van Den Bruel, and Rajan Maghera
 */
public class StudentGradebook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GradebookFrame gradebookFrame = new GradebookFrame();
        ClassFrame classFrame = new ClassFrame();
        ScheduleFrame scheduleFrame = new ScheduleFrame();
        PerformanceFrame performanceFrame = new PerformanceFrame();
        
        gradebookFrame.setVisible(true);

    }
}
