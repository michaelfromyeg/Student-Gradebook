package studentgradebook;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Michael DeMarco, Jordan Van Den Bruel, and Rajan Maghera
 */
public class StudentGradebook {
    public static GradebookFrame gradebook;
    private static ClassFrame classFrame;
    private static ScheduleFrame scheduleFrame;
    private static PerformanceFrame performanceFrame;
    
    public StudentGradebook() {
        gradebook = new GradebookFrame();
        classFrame = new ClassFrame();
        scheduleFrame = new ScheduleFrame();
        performanceFrame = new PerformanceFrame();
        
        gradebook.setVisible(true);
    }

    public static void main(String[] args) {
        StudentGradebook begin = new StudentGradebook();
        gradebook.classButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classFrame.setVisible(true);
            }
        });
    }
    
    /*
       class ClassButtonListener implements MouseListener {
      public void mouseClicked(MouseEvent e) {
         classFrame.setVisible(true);
         gradebook.setVisible(false);
      }
   }
*/

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

