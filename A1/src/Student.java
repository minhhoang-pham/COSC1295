
import java.util.HashSet;
import java.util.Set;

public class Student {
    private String name;
    private Set<Course> enrolledCourses = new HashSet<>();

    public Student(String name) {
        this.name = name;
    }

    public void enrol(Course course) {
        this.enrolledCourses.add(course);
    }

    public Set<Course> getEnrolledCourses() {
        return this.enrolledCourses;
    }
}
