package academy;

import java.util.List;

public class Student extends Person{
    // Fields
    private final Person person;
    private List<Course> courses;

    // Constructor
    public Student(Person person, List<Course> courses) {
        this.person = person;
        this.courses = courses;
    }

    // How many courses the person is taking.
    public int numberOfCoursesTaken() {
        return courses.size();
    }

    // Getters and Setters
    public Person getStudent() {
        return person;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
