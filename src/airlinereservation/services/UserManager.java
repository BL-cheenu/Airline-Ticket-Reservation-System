package airlinereservation.services;

import airlinereservation.models.Admin;
import airlinereservation.models.Passenger;
import airlinereservation.models.User;
import airlinereservation.utils.ScannerHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private List<User> userDatabase;
    private int userCounter = 1;

    public UserManager() {
        this.userDatabase = new ArrayList<>();
        // Pre-create an admin for testing
        userDatabase.add(new Admin("U0000", "Super Admin", "admin@airline.com", "9999999999", "admin123", "01/01/1980"));
    }

    public User login(Scanner scanner) {
        System.out.println("\n--- User Login ---");
        String email = ScannerHelper.readEmail(scanner, "  Email: ");
        String password = ScannerHelper.readNonEmptyString(scanner, "  Password: ");

        for (User user : userDatabase) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                System.out.println(">> Login Successful! Welcome, " + user.getName());
                return user;
            }
        }
        
        System.out.println(">> Invalid email or password.");
        return null;
    }

    public void registerPassenger(Scanner scanner) {
        System.out.println("\n--- Passenger Registration ---");
        
        String email = ScannerHelper.readEmail(scanner, "  Enter Email: ");
        
        // Check if email already exists
        if (userDatabase.stream().anyMatch(u -> u.getEmail().equalsIgnoreCase(email))) {
            System.out.println(">> Error: An account with this email already exists!");
            return;
        }

        String name = ScannerHelper.readNonEmptyString(scanner, "  Enter Full Name: ");
        String phone = ScannerHelper.readMobile(scanner, "  Enter Mobile Number: ");
        String dob = ScannerHelper.readNonEmptyString(scanner, "  Enter Date of Birth (DD/MM/YYYY): ");
        String passport = ScannerHelper.readNonEmptyString(scanner, "  Enter Passport/ID Number: ");
        String password = ScannerHelper.readPassword(scanner, "  Create Password (min 6 chars): ");

        String userId = String.format("U%04d", userCounter++);
        
        Passenger passenger = new Passenger(userId, name, email, phone, password, dob, passport);
        userDatabase.add(passenger);
        
        System.out.println(">> Registration Successful! You can now log in.");
        System.out.println("   Your User ID is: " + userId);
    }
}
