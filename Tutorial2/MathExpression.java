import java.util.Scanner;

public class MathExpression {
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter a math expression: ");
            String expression = scan.nextLine();

            String[] expressionSplit = expression.split(" ");
            if (expressionSplit.length != 3) {
                System.out.println("Invalid format! Please enter in 'number operator number' format with space between the number and operator.");
            }
            else {
                try {
                    double num1 = Double.parseDouble(expressionSplit[0]);
                    double num2 = Double.parseDouble(expressionSplit[2]);
                    double result = 0;
                    boolean calculated = true;

                    switch (expressionSplit[1]) {
                        case "+" -> result = num1 + num2;
                        case "-" -> result = num1 - num2;
                        case "*" -> result = num1 * num2;
                        case "/" -> result = num1 / num2;
                        default -> {
                            System.out.println("Invalid operator! Please use +, -, *, or /");
                            calculated = false;
                        }

                    }

                    if (calculated == true) {
                        System.out.println("Result: " + result);
                    }
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}
