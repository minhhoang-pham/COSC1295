
import java.util.HashSet;
import java.util.Set;

public class Student {
    private String name;
    private Set<String> enrolledCourses = new HashSet<>();

    public Student(String name) {
        this.name = name;
    }
}
