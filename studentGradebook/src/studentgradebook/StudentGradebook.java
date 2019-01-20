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
    public static ArrayList<Course> courses = new ArrayList<Course>();
    public static int coursesNum;
    public static String[][] courseArray;
    public StudentGradebook() {
        gradebook = new GradebookFrame();
        classFrame = new ClassFrame();
        scheduleFrame = new ScheduleFrame();
        performanceFrame = new PerformanceFrame();
        
        gradebook.setVisible(true);
    }

    public static void main(String[] args) {
        StudentGradebook begin = new StudentGradebook();
        
        Course c1 = new Course("Math","Room 123","Mr. Artym");
        Course c2 = new Course("History","Room 546","Mrs. Usher");
        Course c3 = new Course("English","Room 435","Mrs. Jacobsen");
        
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        
        courseArray = new String[3][courses.size()];
        for (int i = 0; i < StudentGradebook.courses.size(); i ++) {
          courseArray[i][0] = StudentGradebook.courses.get(i).getCourseName();
         courseArray[i][1] = StudentGradebook.courses.get(i).getLocation();
         courseArray[i][2] = StudentGradebook.courses.get(i).getTeacher();
}
             
        System.out.println(courses.size());
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

 }

