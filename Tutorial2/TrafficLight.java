import java.util.*;

public class TrafficLight {
    public static void main(String[] args) {
        boolean running = true;

        while (running) { 
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter traffic light colour (red, yellow, green): ");
            String input = scan.next().toLowerCase().strip();

            switch (input) {
                case "red" -> System.out.println("Action: Stop");
                case "yellow" -> System.out.println("Action: Slow down");
                case "green" -> System.out.println("Action: Go");
                default -> System.out.println("Invalid input, please choose from the list");
            }
        }

  }
}