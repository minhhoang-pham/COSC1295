
import java.util.Set;

public class Student {
    private String name;
    private Set<String> enrolledCourses;

    public Student(
        String name,
        Set<String> enrolledCourses
    ) {
        this.name = name;
        this.enrolledCourses = enrolledCourses;
    }
}
