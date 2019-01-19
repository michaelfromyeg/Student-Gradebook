/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentgradebook;

import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Michael DeMarco, Jordan Van Den Bruel, and Rajan Maghera
 */
public class StudentGradebook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try { 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        GradebookFrame gradebookFrame = new GradebookFrame();
        ClassFrame classFrame = new ClassFrame();
        ScheduleFrame scheduleFrame = new ScheduleFrame();
        PerformanceFrame performanceFrame = new PerformanceFrame();
        ArrayList<Course> courses = new ArrayList<>();
        
        Course c1 = new Course("Math", "Room 123", "Mr. Jones");
        Course c2 = new Course("English","Room 512", "Mrs. Zhao");
        Course c3 = new Course("History", "Room 666", "Mr. Maghera");
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        
        gradebookFrame.setVisible(true);

    }
}
