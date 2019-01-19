package studentgradebook;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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


    
}

