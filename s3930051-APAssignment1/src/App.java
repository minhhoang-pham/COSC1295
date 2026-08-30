import java.util.ArrayList;
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
                    printCourses(student1, "show");
                    menuSelection = mainMenu(scanner);
                    break;
                case 3:
                    withdrawCourse(scanner, student1);
                    menuSelection = mainMenu(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid selection");
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
        // Exit if there are no valid results
        if (searchResult.isEmpty()) {
            System.out.println("No valid results");
            return 0;
        }

        // Output header
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
        int selectedCourseIndex = menuSelection - 1;
        
        // Check if student is already enrolled, if not then enrol
        if ((selectedCourseIndex < 0) || (selectedCourseIndex > searchResult.size() - 1)) {
            System.out.println("Invalid selection");
        } else {
            Course selectedCourse = searchResult.get(selectedCourseIndex);
            if (student.enrol(selectedCourse)) {
                System.out.println("You have enrolled in " + selectedCourse.getCourseName());
            } else {
                System.out.println("You are already enrolled in this course");
            }
        }
   
        return menuSelection;
    }

    private static void printCourses(Student student, String type) {
        Set<Course> enrolledCourses = student.getEnrolledCourses();

        // Adapt based on if the student is viewing a course normally or withdrawing
        if (enrolledCourses.isEmpty()) {
            System.out.println("You don't have any courses enrolled.");
        } else {
            System.out.println("-------------------------------------");
            if ("show".equals(type)) {
                System.out.println("You are enrolled in the following course(s):");
            } else if ("withdraw".equals(type)) {
                System.out.println("Please choose a course to withdraw:");
            }
            System.out.println("-------------------------------------");

            // Outputs the relevant information
            int listNumber = 1;
            for (Course course : enrolledCourses) {
                System.out.println(
                    listNumber + ") " + 
                    course.getCourseName() + "\t" +
                    course.getDeliveryMode() + "\t" +
                    course.getDayOfLecture() + "\t" +
                    course.getTimeOfLecture()
                );
                listNumber += 1;
            }
        }
    }

    private static int withdrawCourse(Scanner scanner, Student student) {
        // Convert to list for accessing elements
        List<Course> enrolledCourses = new ArrayList<>(student.getEnrolledCourses());

        printCourses(student, "withdraw");

        System.out.print("Please select: ");
        int menuSelection = scanner.nextInt();
        int selectedCourseIndex = menuSelection - 1;

        // Withdraw confirm message
        if ((selectedCourseIndex < 0) || (selectedCourseIndex > enrolledCourses.size() - 1)) {
            System.out.println("Invalid selection");
        } else {
            Course selectedCourse = enrolledCourses.get(selectedCourseIndex);
            if (student.withdraw(selectedCourse)) {
                System.out.println("You have withdrawn from " + selectedCourse.getCourseName());
            }
        }
   
        return menuSelection;
    }
}
