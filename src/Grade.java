public class Grade {
    // declaring my attributes of the grade class
    private String assignment;
    private double score;

    // creating my constructor for when I create a new grade for a specific student
    public Grade(String assignment, double score){
        this.assignment = assignment;
        this.score = score;
    }

    // creating getters and setters for my Grade attributes
    // these are not as complicated as the Student attributes
    public String getAssignment() {
        return assignment;
    }
    public void setAssignment(String assign) {
        this.assignment = assign;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
}
