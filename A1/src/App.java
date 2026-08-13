import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CourseList courseList = new CourseList();
        Student student1 = new Student("Eric");
        Scanner scanner = new Scanner(System.in);
        int menuSelection = 0;

        System.out.println("Welcome to MyTimetable!");
        menuSelection = mainMenu(scanner);

        switch (menuSelection) {
            case 1:
                courseSearch(scanner, student1, courseList);
                break;
            default:
                throw new AssertionError();
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
        int optionNumber = 1;
        System.out.println("-------------------------------------");
        System.out.println("> Select from list");
        System.out.println("-------------------------------------");
        for (Course course : searchResult) {
            System.out.print(optionNumber + ") " + course.getCourseName() + "\n");
            optionNumber += 1;
        }
        optionNumber = 1;
        Course selectedCourse = searchResult.get(optionNumber - 1);

        System.out.print("Please select: ");
        int menuSelection = scanner.nextInt();
        System.out.println("You have enrolled in " + selectedCourse.getCourseName());

        student.enrol(selectedCourse);

        return menuSelection;
    }
}
