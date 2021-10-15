package introduction;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {

    private Greeting greeting;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before - I am only called once!!!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In Before Each...");
        greeting = new Greeting();
    }

    @DisplayName("Test Hello World")
    @Test
    void helloWorld() {
        System.out.println(greeting.helloWorld());
        assertEquals("Hello World", greeting.helloWorld(), "Test #1 Failed");
    }

    @DisplayName("Test Hello Everett")
    @Test
    void testHelloWorld() {
        System.out.println(greeting.helloWorld("Adam"));
        assertEquals("Hello Everett", greeting.helloWorld("Everett"), "Test #2 Failed");
    }

    @DisplayName("Test Hello Adam")
    @Test
    void testHelloWorld2() {
        System.out.println(greeting.helloWorld("Adam"));
        assertEquals("Hello Adam", greeting.helloWorld("Adam"), "Test #3 Failed");
    }

    @AfterEach
    void tearDown() {
        System.out.println("In After Each....");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After!!! **** - I am only class once!!!");
    }
}