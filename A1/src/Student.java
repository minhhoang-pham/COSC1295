
import java.util.HashSet;
import java.util.Set;

public class Student {
    private String name;
    private Set<Course> enrolledCourses = new HashSet<>();

    public Student(String name) {
        this.name = name;
    }

    public boolean enrol(Course course) {
        return this.enrolledCourses.add(course);
    }

    public boolean withdraw(Course course) {
        return this.enrolledCourses.remove(course);
    }

    public Set<Course> getEnrolledCourses() {
        return this.enrolledCourses;
    }
}
