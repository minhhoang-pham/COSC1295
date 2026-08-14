import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        CourseList courseList = new CourseList();
        Student student1 = new Student("Eric");
        Scanner scanner = new Scanner(System.in);
        int menuSelection = 0;

        System.out.println("Welcome to MyTimetable!");
        menuSelection = mainMenu(scanner);

        while (true) {
            switch (menuSelection) {
                case 1:
                    courseSearch(scanner, student1, courseList);
                    menuSelection = mainMenu(scanner);
                    break;
                case 2:
                    printCourses(student1);
                    menuSelection = mainMenu(scanner);
                    break;
                case 0:
                    return;
                default:
                    menuSelection = mainMenu(scanner);
                    break;
            }
        }

    }

    private static int mainMenu(Scanner scanner) {
        System.out.println("-------------------------------------");
        System.out.println("> Select from main menu");
        System.out.println("-------------------------------------");
        System.out.println("1) Search by keyword to enroll");
        System.out.println("2) Show my enrolled courses");
        System.out.println("3) Withdraw from a course");
        System.out.println("0) Exit");
        System.out.print("Please select: ");

        int input = scanner.nextInt();
        return input;
    }

    private static int courseSearch(Scanner scanner, Student student, CourseList courseList) {
        System.out.print("Search term: ");
        String searchInput = scanner.next();

        List<Course> searchResult = courseList.courseSearch(searchInput);
        int listNumber = 1;
        System.out.println("-------------------------------------");
        System.out.println("> Select from list");
        System.out.println("-------------------------------------");
        for (Course course : searchResult) {
            System.out.print(listNumber + ") " + course.getCourseName() + "\n");
            listNumber += 1;
        }
        
        System.out.print("Please select: ");
        int menuSelection = scanner.nextInt();
        Course selectedCourse = searchResult.get(menuSelection - 1);

        System.out.println("You have enrolled in " + selectedCourse.getCourseName());

        student.enrol(selectedCourse);

        return menuSelection;
    }

    private static void printCourses(Student student) {
        Set<Course> enrolledCourses = student.getEnrolledCourses();

        if (enrolledCourses.isEmpty()) {
            System.out.println("You don't have any courses enrolled.");
        } else {
            System.out.println("-------------------------------------");
            System.out.println("You are enrolled in the following course(s):");
            System.out.println("-------------------------------------");

            int listNumber = 1;
            for (Course course : enrolledCourses) {
                System.out.println(
                    listNumber + ")" + 
                    course.getCourseName() + "\t" +
                    course.getDeliveryMode() + "\t" +
                    course.getDayOfLecture() + "\t" +
                    course.getTimeOfLecture()
                );
                listNumber += 1;
            }
        }
    }
}
