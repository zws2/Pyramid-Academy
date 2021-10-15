package academy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

//https://junit.org/junit5/docs/current/user-guide/
class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        // Creating a new student that take a person and a list of courses.
        student = new Student(new Person("Adam Ingram", 40, "ATL"),
                Arrays.asList(new Course("100", "course1", "author1"),
                        new Course("101", "course2", "author2"),
                        new Course("102", "course3", "author3")));
    }

    // This test is checking the number of courses a student is taking.
    @Test
    void numberOfCoursesTaken() {
        assertEquals(3, student.numberOfCoursesTaken());
    }

    // This test case is using grouped assertions. It will allow you to run multiple test.
    @Test
    void groupedAssertions() {
        // Here we are updating the student name from Adam Ingram to Lindsay Ingram.
        student.getStudent().setFullName("Lindsay Ingram");
        // Here we are updating the student age to 25.
        student.getStudent().setAge(25);
        assertAll("Group Tests",
                () -> assertEquals("Lindsay Ingram", student.getStudent().getFullName(), "Name name failed."),
                () -> assertEquals(25, student.getStudent().getAge(), "Wrong age."),
                () -> assertEquals("ATL", student.getStudent().getAddress(), "Wrong address."),
                () -> assertEquals(3, student.numberOfCoursesTaken(), "Wrong number of courses."));
    }
}