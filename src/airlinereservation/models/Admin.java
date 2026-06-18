package airlinereservation.models;

public class Admin extends User {
    
    public Admin(String userId, String name, String email, String phone, String password, String dateOfBirth) {
        super(userId, name, email, phone, password, dateOfBirth);
    }

    @Override
    public String getRoleName() {
        return "ADMIN";
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- Admin Menu ---");
        System.out.println("1. View Profile");
        System.out.println("2. Manage Users (Coming Soon)");
        System.out.println("3. Manage Flights (Coming Soon)");
        System.out.println("4. Logout");
    }
}
