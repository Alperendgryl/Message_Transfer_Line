package comp2102_project_q2;

public class Student {

    String studentName;
    Student nextStudent;
    Student previousStudent;
    boolean hub;

    public Student(String name) {
        this.studentName = name;
        this.nextStudent = null;
        this.previousStudent = null;
        this.hub = false;
    }

    public String getName() {
        return studentName;
    }

    @Override
    public String toString() {
        return studentName;
    }

    public void setHub(boolean hub) {
        this.hub = hub;
    }
}
