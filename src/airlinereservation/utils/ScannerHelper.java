package airlinereservation.utils;

import java.util.Scanner;

public class ScannerHelper {

    public static int readInt(Scanner scanner) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.print(">> Invalid input. Please enter a valid number: ");
            }
        }
    }

    public static String readNonEmptyString(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println(">> Input cannot be empty. Please try again.");
        }
    }

    public static String readEmail(Scanner scanner, String prompt) {
        String email;
        while (true) {
            System.out.print(prompt);
            email = scanner.nextLine().trim();
            if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                return email;
            }
            System.out.println(">> Invalid email format. Please try again.");
        }
    }

    public static String readMobile(Scanner scanner, String prompt) {
        String mobile;
        while (true) {
            System.out.print(prompt);
            mobile = scanner.nextLine().trim();
            if (mobile.matches("^[6-9]\\d{9}$")) {
                return mobile;
            }
            System.out.println(">> Invalid mobile number. Must be 10 digits starting with 6-9. Try again.");
        }
    }

    public static String readPassword(Scanner scanner, String prompt) {
        String password;
        while (true) {
            System.out.print(prompt);
            password = scanner.nextLine().trim();
            if (password.length() >= 6) {
                return password;
            }
            System.out.println(">> Password must be at least 6 characters long.");
        }
    }
}
