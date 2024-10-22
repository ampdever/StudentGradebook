import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
    //I have to create a list of Students to be accessible for the creating of my gradebook
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        // Options for the user
        System.out.println("Please make a selection: ");
        System.out.println("1. Enter new Student");
        System.out.println("2. Enter a new grade");
        System.out.println("3. Update a grade");
        System.out.println("4. View Student's grades");
        System.out.println("5. View all grades");
        System.out.println("0. Exit");
        System.out.print("Selection: ");

        int answer = 0;
        Scanner input = new Scanner(System.in);
        String response = input.nextLine();
        answer = Integer.parseInt(response);

        while(answer != 0) {
            if(answer == 1) {

                //make a new student
                System.out.print("Please enter the name of the student: ");
                String name = input.nextLine();

                Student newStudent = new Student(name);
                students.add(newStudent);

            } else if (answer == 2) {

                //make them select a new student and then enter in the grade for them
                System.out.println("Please select the student with the new grade.");
                displayAllStudents();
                int selection = Integer.parseInt(input.nextLine()) - 1 ;

                // in testing I found that I could break this by making a wrong selection
                // so I'm adding a selection check
                if (selection < students.size()) {

                    //collect inputs for the assignment and grades
                    System.out.print("Please enter the assignment name: ");
                    String assignment = input.nextLine();
                    System.out.print("Please enter the grade percentage: ");
                    double grade = Double.parseDouble(input.nextLine());

                    // create the new grade for the student
                    Student userChoice = students.get(selection);
                    Grade newGrade = new Grade(assignment, grade);

                    // adding the new assignment/grade
                    userChoice.setGrade(newGrade);

                } else {
                    System.out.println("Selection is not found!");
                }

            } else if (answer == 3) {
                //select a student, select a grade, enter a new grade
                System.out.println("Please select the student who had a grade change.");
                displayAllStudents();
                int selection = Integer.parseInt(input.nextLine()) - 1;
                Student userChoice = students.get(selection);
                
                System.out.println("Please select the assignment with the grade change");
                displayStudentGrades(userChoice);
                int gradeSelection = Integer.parseInt(input.nextLine()) - 1;

                if (gradeSelection < userChoice.getGrades().size()) {
                    System.out.print("Please enter the updated grade: ");
                    double gradeUpdate = Double.parseDouble(input.nextLine());
                    
                    //takes the student that was selected by the user and also takes the assignment
                    // selected by the user and using the changeGrade function it updates the grade
                    userChoice.changeGrade(gradeSelection, new Grade(userChoice.getGrades().get(gradeSelection).getAssignment(), gradeUpdate));
                    System.out.println("Grade was updated.");
                }

                
            } else if (answer == 4) {
                // select a student and then it will show the grades
                System.out.println("Please select the student whose grades you want to see.");
                displayAllStudents();
                int selection = Integer.parseInt(input.nextLine()) - 1;
                Student userChoice = students.get(selection);

                displayStudentGrades(userChoice);

            } else if (answer == 5) {
                // show all students and grades
                // I initially did this with a for loop but I learned that a foreach loop
                // was very simple
                for (Student student : students) {
                    displayStudentGrades(student);
                }
                
            } else {System.out.println("Please make a valid selection"); }

            // Options for the user with some spacing
            System.out.println();
            System.out.println();
            System.out.println("Please make a selection: ");
            System.out.println("1. Enter new Student");
            System.out.println("2. Enter a new grade");
            System.out.println("3. Update a grade");
            System.out.println("4. View Student's grades");
            System.out.println("5. View all grades");
            System.out.println("0. Exit");
            System.out.print("Selection: ");
            answer = Integer.parseInt(input.nextLine());
        }
        // This is needed in java to prevent resource leaks for input from users]
        input.close();
    }

    // since I'm going to be showing all the students I'm going to check if the list is empty
    // and only display students when it's not empty
    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("STUDENTS:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i+1) + " - " + students.get(i).getName());
            // the students.get(i).getName() was hard to figure out because I kept
            // returning the student object instead of the name. The .get(i) returns the
            // correct object at the i index and the .getName() returns the name of the object.
        }
    }

    private static void displayStudentGrades(Student student) {
        // make sure there are students to be able to display grades for.
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        // formatting for showing the students and then looping through that one students grades.
        // the student comes from the student that is passed in as a paramter.
        System.out.println(student.getName() + "'s grades: ");
        for (int i = 0; i < student.getGrades().size(); i++) {
            Grade grade = student.getGrades().get(i);
            System.out.println((i + 1) + " - Assignment: " + grade.getAssignment() + ", Grade: " + grade.getScore());
        }
    }
}
