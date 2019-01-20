package studentgradebook;

import com.alee.laf.WebLookAndFeel;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
    private static AddCourse addCourse;
    private static AddAssignment addAssignment;
    private static AddTest addTest;
    
    public StudentGradebook() {
        gradebook = new GradebookFrame();
        classFrame = new ClassFrame();
        scheduleFrame = new ScheduleFrame();
        performanceFrame = new PerformanceFrame();
        addCourse = new AddCourse();
        addAssignment = new AddAssignment();
        addTest = new AddTest();
        
        gradebook.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        
        UIManager.setLookAndFeel ( new WebLookAndFeel () );
        
        StudentGradebook begin = new StudentGradebook();
        
        Course c1 = new Course("Math","Room 123","Mr. Artym");
        Course c2 = new Course("History","Room 546","Mrs. Usher");
        Course c3 = new Course("English","Room 435","Mrs. Jacobsen");
        
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        
<<<<<<< HEAD
        //gradebookFrame --> classFrame
=======
        courseArray = new String[3][courses.size()];
        for (int i = 0; i < StudentGradebook.courses.size(); i ++) {
          courseArray[i][0] = StudentGradebook.courses.get(i).getCourseName();
         courseArray[i][1] = StudentGradebook.courses.get(i).getLocation();
         courseArray[i][2] = StudentGradebook.courses.get(i).getTeacher();
}
             
        System.out.println(courses.size());
>>>>>>> dfb697b1879670b8be3eb2d1d249162a8a5c9101
        gradebook.classButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classFrame.setVisible(true);
                classFrame.toFront();
            }
        });
        //gradebookFrame --> scheduleFrame
        gradebook.scheduleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scheduleFrame.setVisible(true);
                scheduleFrame.toFront();
            }
        });
        //gradebookFrame --> performanceFrame
        gradebook.performanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                performanceFrame.setVisible(true);
                performanceFrame.toFront();
            }
        });
<<<<<<< HEAD
        //back button on classFrame --> gradebookFrame
        classFrame.jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
=======
        classFrame.backButton.addMouseListener(new java.awt.event.MouseAdapter() {
>>>>>>> dfb697b1879670b8be3eb2d1d249162a8a5c9101
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradebook.setVisible(true);
                gradebook.toFront();
            }
        });
        //back button on performanceFrame --> gradebookFrame
        performanceFrame.jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradebook.setVisible(true);
                gradebook.toFront();
            }
        });
        //back button on scheduleFrame --> gradebookFrame
        scheduleFrame.jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradebook.setVisible(true);
                gradebook.toFront();
            }
        }); 
<<<<<<< HEAD
        //classButton on classFrame --> addCourse
        classFrame.jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
=======
        classFrame.addClassButton.addMouseListener(new java.awt.event.MouseAdapter() {
>>>>>>> dfb697b1879670b8be3eb2d1d249162a8a5c9101
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCourse.setVisible(true);
                gradebook.toFront();
            }
        });
        //cancel button on addCourse --> classFrame
        addCourse.jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classFrame.setVisible(true);
                classFrame.toFront();
            }
        });
        //cancel button on addAssignment --> classFrame
        addAssignment.jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classFrame.setVisible(true);
                classFrame.toFront();
            }
        });
        //cancel button on addTest --> classFrame
        addTest.jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classFrame.setVisible(true);
                classFrame.toFront();
            }
        });
        //add button on AddCourse
        addCourse.addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courses.add(new Course(addCourse.nameField.getText(), addCourse.locationField.getText(), addCourse.teacherField.getText()));
                
                classFrame.setVisible(true);
                classFrame.toFront();
            }
        });        
    }
<<<<<<< HEAD
=======
    
    public static void importCourse(File file) throws ClassNotFoundException {
        
        Course c = null;
        
        try {
         FileInputStream fileIn = new FileInputStream(file);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         c = (Course) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
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
>>>>>>> dfb697b1879670b8be3eb2d1d249162a8a5c9101

 }