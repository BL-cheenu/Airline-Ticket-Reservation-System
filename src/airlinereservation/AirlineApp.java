package airlinereservation;

import airlinereservation.models.User;
import airlinereservation.services.UserManager;
import airlinereservation.utils.ScannerHelper;

import java.util.Scanner;

public class AirlineApp {
    private static UserManager userManager = new UserManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("=================================================");
        System.out.println("       Airline Ticket Reservation System         ");
        System.out.println("=================================================");

        while (!exit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Login");
            System.out.println("2. Register as Passenger");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = ScannerHelper.readInt(scanner);

            switch (choice) {
                case 1:
                    User loggedInUser = userManager.login(scanner);
                    if (loggedInUser != null) {
                        handleUserSession(scanner, loggedInUser);
                    }
                    break;
                case 2:
                    userManager.registerPassenger(scanner);
                    break;
                case 3:
                    exit = true;
                    System.out.println(">> Thank you for using the Airline Reservation System. Goodbye!");
                    break;
                default:
                    System.out.println(">> Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void handleUserSession(Scanner scanner, User user) {
        boolean logout = false;

        while (!logout) {
            user.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = ScannerHelper.readInt(scanner);

            switch (choice) {
                case 1:
                    System.out.println("\n--- My Profile ---");
                    System.out.println(user.toString());
                    System.out.println("Phone: " + user.getPhone());
                    System.out.println("DOB: " + user.getDateOfBirth());
                    break;
                case 4:
                    logout = true;
                    System.out.println(">> Logging out...");
                    break;
                default:
                    System.out.println(">> Feature coming soon or Invalid choice.");
            }
        }
    }
}
