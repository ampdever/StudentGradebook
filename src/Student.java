import java.util.ArrayList;
import java.util.List;

public class Student {
    // declaring my attributes for each student
    private String name;
    private List<Grade> grades;

    // creating my constructor for when I create a new Student
    public Student(String name) {
        this.name = name;
        // ArrayList is a class where you can store a list of objects.
        // In this case I will store a list of Grade objects for each student.
        this.grades = new ArrayList<>();
    }

    // creating getters and setters for my Student name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    // getter for the Grades
    public List<Grade> getGrades() {
        return grades;
    }
    // for setting the grades this is a little diferent
    // because I'm going to be creating a grade object
    // I need to use the grade constructor within this setter
    public void setGrade(Grade grade) {
        grades.add(grade);
    }
    
    public void changeGrade(int num, Grade changedGrade) {
        if (num < grades.size()) {
            grades.set(num, changedGrade);
        }
    }
}
