import java.util.*;

public class PasswordEvaluation {
    public static void main (String[] args) {
        boolean running = true;
        while (running) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter a password: ");
            String password = scan.next();

            System.out.print("Password Strength: ");
            if (password.length() < 6 || !hasDigits(password) || !hasLetters(password)) {
                System.out.print("Weak\n");
            }
            else if (password.length() > 10 && hasDigits(password) && hasLetters(password) && hasSpecialCharacters(password)) {
                System.out.print("Strong\n");
            }
            else {
                System.out.print("Moderate\n");
            }
        }
    }

    private static boolean hasDigits(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasLetters(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSpecialCharacters(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetterOrDigit(str.charAt(i)) && !Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}