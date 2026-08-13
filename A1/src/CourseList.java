import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CourseList {
    private List<Course> courses = new ArrayList<>();

    public CourseList() {
        ImportCourses();
    }

    private void ImportCourses(){
        String fileName = "course.csv";
        String dir = ".";
        
        try (BufferedReader br = new BufferedReader(new FileReader(new File(dir, fileName)))) {
            // Read and discard the header row
            String headerLine = br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                this.courses.add(new Course(
                    data[0], 
                    data[1], 
                    data[2], 
                    data[3], 
                    data[4], 
                    data[5], 
                    Float.parseFloat(data[6])
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
