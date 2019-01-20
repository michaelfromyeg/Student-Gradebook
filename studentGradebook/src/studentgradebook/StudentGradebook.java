package studentgradebook;

import com.alee.laf.WebLookAndFeel;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;


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
    private static ClassView classView;
    
    public static void createDatabase() {
        
        Course c1 = new Course("Math","Room 123","Mr. Artym");
        Course c2 = new Course("History","Room 546","Mrs. Usher");
        Course c3 = new Course("English","Room 435","Mrs. Jacobsen");
        
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        
        StudentGradebook.courseArray = new String[3][StudentGradebook.courses.size()];
        for (int i = 0; i < StudentGradebook.courses.size(); i ++) {
            StudentGradebook.courseArray[i][0] = StudentGradebook.courses.get(i).getCourseName();
            StudentGradebook.courseArray[i][1] = StudentGradebook.courses.get(i).getLocation();
            StudentGradebook.courseArray[i][2] = StudentGradebook.courses.get(i).getTeacher();
        }       
        
        
        
    }
    
    public StudentGradebook() {
        gradebook = new GradebookFrame();
        classFrame = new ClassFrame();
        scheduleFrame = new ScheduleFrame();
        performanceFrame = new PerformanceFrame();
        addCourse = new AddCourse();
        addAssignment = new AddAssignment();
        addTest = new AddTest();
        classView = new ClassView();
        
        gradebook.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        
        UIManager.setLookAndFeel ( new WebLookAndFeel () );
        
        StudentGradebook begin = new StudentGradebook();
        
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

        classFrame.backButton.addMouseListener(new java.awt.event.MouseAdapter() {
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
        classFrame.addClassButton.addMouseListener(new java.awt.event.MouseAdapter() {
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
//thinger here
                courses.add(new Course(addCourse.nameField.getText(), addCourse.locationField.getText(), addCourse.teacherField.getText()));
                Course c = new Course(addCourse.nameField.getText(), addCourse.locationField.getText(), addCourse.teacherField.getText());
                courses.add(c);
                System.out.print(c);
                //saveCourse(c);
                classFrame.setVisible(true);
                classFrame.toFront();
            }
        });
        //backButton in ClassView --> ClassFrame
        classView.backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classFrame.setVisible(true);
                classFrame.toFront();
            }
        });
        //viewClass button in classFrame --> ClassViewFrame
        classFrame.viewClassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classView.setVisible(true);
                classView.toFront();
            }
        });
        
        classFrame.importClassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                final JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(null);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    try {
                        importCourse(file);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(StudentGradebook.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Opening: " + file.getName() + ".");
                } else {
                    System.out.println("Open command cancelled by user.");
                }
            }
            });
    }
    
    public static void importCourse(File file) throws ClassNotFoundException {
        Course c = null;
        try {
         FileInputStream fileIn = new FileInputStream(file);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         c = (Course) in.readObject();
         courses.add(c);
         in.close();
         fileIn.close();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    
    public static void saveCourse(Course course) {
        try {
            FileOutputStream fileOut =
            new FileOutputStream("/tmp/" + course.getCourseName() + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(course);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/" + course.getCourseName() + ".ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 }
