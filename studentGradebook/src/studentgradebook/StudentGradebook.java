package studentgradebook;

//import com.alee.laf.WebLookAndFeel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Michael DeMarco, Jordan Van Den Bruel, and Rajan Maghera
 */

public class StudentGradebook {
    public static CalculatorForm calculatorForm;
    public static ArrayList<Course> courses = new ArrayList<Course>();
    public static Course courseChoice = new Course("", "", "");
    public static Test testChoice = new Test("", 0, 0);
    public static String[][] courseArray;
    public static String[][] testArray;
    public static String[][] marksArray;
    public static String[] courseList;
    public static String filename = "logo.png";
    public static String workingDir = System.getProperty("user.dir");
    public static String filepath = workingDir + File.separator + "\\src\\studentgradebook\\" + filename;
    public static ImageIcon img = new ImageIcon(filepath);
    private static GradebookFrame gradebook;
    private static ClassFrame classFrame;
    private static PerformanceFrame performanceFrame;
    private static AddCourse addCourse;
    private static AddTest addTest;
    private static ClassView classView;

    public StudentGradebook() {
        gradebook = new GradebookFrame();
        classFrame = new ClassFrame();
        performanceFrame = new PerformanceFrame();
        addCourse = new AddCourse();
        addTest = new AddTest();
        classView = new ClassView();
        calculatorForm = new CalculatorForm();
        gradebook.setVisible(true);

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        //UIManager.setLookAndFeel ( new WebLookAndFeel () );
        StudentGradebook begin = new StudentGradebook();
        System.out.println(courses.size());
        initialImport();
        gradebook.setIconImage(img.getImage());
        classFrame.setIconImage(img.getImage());
        performanceFrame.setIconImage(img.getImage());
        addCourse.setIconImage(img.getImage());
        addTest.setIconImage(img.getImage());
        classView.setIconImage(img.getImage());
        calculatorForm.setIconImage(img.getImage());

        //gradebookFrame --> classFrame
        gradebook.classButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classFrame.refreshTable.doClick();
                classFrame.setVisible(true);
                classFrame.toFront();
            }
        });
        //gradebookFrame --> performanceFrame
        gradebook.performanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                performanceFrame.setVisible(true);
                performanceFrame.toFront();
                performanceFrame.refreshButton.doClick();
            }
        });

        classFrame.backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classFrame.setVisible(false);
                gradebook.setVisible(true);
                gradebook.toFront();
                gradebook.averageLabel.setText("Current Average: " + StudentGradebook.studentAverage());
            }
        });
        //back button on performanceFrame --> gradebookFrame
        performanceFrame.jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradebook.setVisible(true);
                gradebook.toFront();
                gradebook.averageLabel.setText("Current Average: " + StudentGradebook.studentAverage());
            }
        });
        classFrame.addClassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCourse.setVisible(true);
                gradebook.toFront();
            }
        });
        //cancel button on addCourse --> classFrame
        addCourse.cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classFrame.setVisible(true);
                classFrame.toFront();
            }
        });
        //back button on Calc Form --> performance Frame
        calculatorForm.backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                performanceFrame.setVisible(true);
                performanceFrame.toFront();
                calculatorForm.setVisible(false);
                performanceFrame.refreshButton.doClick();
            }
        });
        //calculate test button to Calculator form
        performanceFrame.jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calculatorForm.classSelector.removeAllItems();
                calculatorForm.setVisible(true);
                calculatorForm.toFront();
                performanceFrame.setVisible(false);
                for (int i = 0; i < StudentGradebook.courses.size(); i++) {
                    calculatorForm.classSelector.addItem(StudentGradebook.courses.get(i).getCourseName());
                }
                calculatorForm.initMarks();
            }
        });
        addCourse.addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Course c = new Course(addCourse.nameField.getText(), addCourse.locationField.getText(), addCourse.teacherField.getText());
                System.out.println(c.getCourseName());
                saveCourse(c);
                classFrame.setVisible(true);
                classFrame.toFront();
                addCourse.nameField.setText("");
                addCourse.locationField.setText("");
                addCourse.teacherField.setText("");
                addCourse.setVisible(false);
                updateArray();
                classFrame.refreshTable.doClick();
            }
        });
        addTest.addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Test t = new Test(addTest.nameField.getText(), Double.parseDouble(addTest.scoreField.getText()), Double.parseDouble(addTest.weightField.getText()));
                System.out.println(t.getTestName());
                StudentGradebook.courseChoice.addTest(t);
                saveCourse(courseChoice);
                System.out.println("Number of tests in chosen course: " + courseChoice.getTestNum());
                classView.setVisible(true);
                classView.toFront();
                addTest.nameField.setText("");
                addTest.scoreField.setText("");
                addTest.weightField.setText("");
                addTest.setVisible(false);
                updateArrayTests();
                classView.refreshButton.doClick();
            }
        });
        //backButton in ClassView --> ClassFrame
        classView.backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classFrame.setVisible(true);
                classFrame.toFront();
            }
        });
        //viewClass button in classFrame --> ClassViewFrame
        classFrame.viewClassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (classFrame.classTable.getSelectionModel().isSelectionEmpty()) {
                    System.out.println("No row selected.");
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                } else {
                    int index = findIndexbyName(courses, (String) classFrame.classTable.getValueAt(classFrame.classTable.getSelectedRow(), 0));
                    courseChoice = courses.get(index);
                    classView.classLabel.setText(courseChoice.getCourseName());
                    System.out.println(courseChoice);
                    classView.setVisible(true);
                    classView.refreshButton.doClick();
                    classView.toFront();
                    classFrame.setVisible(false);
                }
            }
        });
        //addTest button in viewClass --> addTest
        classView.addTest.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTest.setVisible(true);
                addTest.toFront();
                classView.refreshButton.doClick();
                classView.setVisible(false);
            }
        });
        //viewClass button in classFrame --> ClassViewFrame
        addTest.backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classView.setVisible(true);
                classView.toFront();
                addTest.nameField.setText("");
                addTest.scoreField.setText("");
                addTest.weightField.setText("");
                addTest.setVisible(false);
            }
        });
        classFrame.importClassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                final JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Student Gradebook Files", "ser", "serial");
                fc.setFileFilter(filter);

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
                classFrame.refreshTable.doClick();
            }
        });

        //ClassFrame edit/delete

        classFrame.editClassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (classFrame.classTable.getSelectionModel().isSelectionEmpty()) {
                    System.out.println("No row selected.");
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                } else {
                    int index = findIndexbyName(courses, (String) classFrame.classTable.getValueAt(classFrame.classTable.getSelectedRow(), 0));
                    courseChoice = courses.get(index);

                    addCourse.nameField.setText(courseChoice.getCourseName());
                    addCourse.locationField.setText(courseChoice.getLocation() + "");
                    addCourse.teacherField.setText(courseChoice.getTeacher() + "");

                    courses.remove(courseChoice);

                    addCourse.setVisible(true);
                    addCourse.toFront();
                    classFrame.setVisible(false);
                }
            }
        });
        classFrame.deleteClassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (classFrame.classTable.getSelectionModel().isSelectionEmpty()) {
                    System.out.println("No row selected.");
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                } else {
                    int index = findIndexbyName(courses, (String) classFrame.classTable.getValueAt(classFrame.classTable.getSelectedRow(), 0));
                    courseChoice = courses.get(index);

                    String filename = courseChoice.getCourseName() + ".ser";
                    String workingDir = System.getProperty("user.dir");
                    String filepath = workingDir + File.separator + "\\src\\studentgradebook\\tmp\\" + filename;
                    //String filepath = "C:\\Users\\mdema\\Documents\\Github\\studentgradebook\\studentGradebook\\src\\studentgradebook\\tmp\\" + course.getCourseName() + ".ser";
                    System.out.println(filepath);
                    File tmp = new File(filepath);
                    tmp.delete();

                    courses.remove(courseChoice);
                    classFrame.refreshTable.doClick();

                }
            }
        });
        classView.editTestButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (classView.testTable.getSelectionModel().isSelectionEmpty()) {
                    System.out.println("No row selected.");
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                } else {
                    String testName = (String) classView.testTable.getValueAt(classView.testTable.getSelectedRow(), 0);
                    System.out.println(testName);
                    int index = findTestIndexbyName(courseChoice.tests, testName);
                    testChoice = courseChoice.tests.get(index);
                    System.out.println(testChoice);
                    addTest.nameField.setText(testChoice.getTestName());
                    addTest.scoreField.setText(testChoice.getTestScore() + "");
                    addTest.weightField.setText(testChoice.getTestWeighting() + "");

                    courseChoice.tests.remove(testChoice);

                    addTest.setVisible(true);
                    addTest.toFront();
                    classView.setVisible(false);
                }
            }
        });
        classView.deleteTest.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (classView.testTable.getSelectionModel().isSelectionEmpty()) {
                    System.out.println("No row selected.");
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                } else {
                    String testName = (String) classView.testTable.getValueAt(classView.testTable.getSelectedRow(), 0);
                    System.out.println(testName);
                    int index = findTestIndexbyName(courseChoice.tests, testName);
                    testChoice = courseChoice.tests.get(index);
                    System.out.println(testChoice);
                    courseChoice.tests.remove(testChoice);
                    classView.refreshButton.doClick();
                }
            }
        });
    }

    public static void updateArray() {
        courseArray = new String[courses.size()][3];
        for (int i = 0; i < courses.size(); i++) {
            courseArray[i][0] = courses.get(i).getCourseName();
            courseArray[i][1] = courses.get(i).getLocation();
            courseArray[i][2] = courses.get(i).getTeacher();
        }
    }

    public static void updateArrayMarks() {
        marksArray = new String[courses.size()][2];
        for (int i = 0; i < courses.size(); i++) {
            marksArray[i][0] = courses.get(i).getCourseName();
            marksArray[i][1] = Double.toString(courses.get(i).classAverage());

        }
    }

    public static void updateArrayTests() {
        testArray = new String[courseChoice.tests.size()][3];
        for (int i = 0; i < courseChoice.tests.size(); i++) {
            testArray[i][0] = courseChoice.tests.get(i).getTestName();
            testArray[i][1] = courseChoice.tests.get(i).getTestScore() + "";
            testArray[i][2] = courseChoice.tests.get(i).getTestWeighting() + "";
        }
    }

    public static void updateArrayCourseList() {
        courseList = new String[courses.size()];
        for (int i = 0; i < courses.size(); i++) {
            courseList[i] = courses.get(i).getCourseName();
        }

    }

    public static void importCourse(File file) throws ClassNotFoundException {
        Course c;
        try {
            try (FileInputStream fileIn = new FileInputStream(file); ObjectInputStream in = new ObjectInputStream(fileIn)) {
                c = (Course) in.readObject();
                System.out.println(c + ". THIS WAS IMPORTED!");
                System.out.println("Number of tests in imported course: " + c.getTestNum());
                courses.add(c);
            }
        } catch (IOException e) {
        }
    }

    public static void saveCourse(Course course) {
        System.out.println(courses.indexOf(course));
        String filename = course.getCourseName() + ".ser";
        String workingDir = System.getProperty("user.dir");
        String filepath = workingDir + File.separator + "\\src\\studentgradebook\\tmp\\" + filename;
        //String filepath = "C:\\Users\\mdema\\Documents\\Github\\studentgradebook\\studentGradebook\\src\\studentgradebook\\tmp\\" + course.getCourseName() + ".ser";
        System.out.println(filepath);

        File tmp = new File(filepath);
        boolean exists = tmp.exists();

        if (exists) {
            courses.remove(findIndexbyName(courses, course));
            tmp.delete();
            try {
                FileOutputStream fileOut = new FileOutputStream(filepath);
                try (ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                    objectOut.writeObject(course);
                    objectOut.flush();
                }
                System.out.println("The object  was succesfully written to a file.");
                courses.add(course);
                System.out.println("The course was re-added to courses.");
            } catch (IOException ex) {
            }
        } else {
            try {
                FileOutputStream fileOut = new FileOutputStream(filepath);
                try (ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                    objectOut.writeObject(course);
                    objectOut.flush();
                }
                System.out.println("The object  was succesfully written to a file.");
            } catch (IOException ex) {
            }
        }
    }

    public static double studentAverage() {

        double sum = 0.0;
        for (int i = 0; i < courses.size(); i++) {
            sum += courses.get(i).classAverage();
        }
        return sum / courses.size();
    }

    public static int findIndexbyName(ArrayList<Course> courses, Course c) {
        for (int i = 0; i < courses.size(); i++) {
            if (c.getCourseName().equals(courses.get(i).getCourseName())) {
                return i;
            }
        }
        return -1;
    }

    public static int findIndexbyName(ArrayList<Course> courses, String courseName) {
        for (int i = 0; i < courses.size(); i++) {
            if (courseName.equals(courses.get(i).getCourseName())) {
                return i;
            }
        }
        return -1;
    }

    public static int findTestIndexbyName(ArrayList<Test> tests, String testName) {
        for (int i = 0; i < tests.size(); i++) {
            if (testName.equals(tests.get(i).getTestName())) {
                return i;
            }
        }
        return -1;
    }

    public static void initialImport() {
        String workingDir = System.getProperty("user.dir");
        String filepath = workingDir + File.separator + "\\src\\studentgradebook\\tmp\\";
        File folder = new File(filepath);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (file.getName().equals(".gitkeep")) {
                    continue;
                }
                System.out.println("Trying to import file " + file.getName());
                try {
                    importCourse(file);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentGradebook.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
