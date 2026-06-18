package airlinereservation.models;

public class AirlineStaff extends User {
    private String staffId;

    public AirlineStaff(String userId, String name, String email, String phone, String password, String dateOfBirth, String staffId) {
        super(userId, name, email, phone, password, dateOfBirth);
        this.staffId = staffId;
    }

    public String getStaffId() { return staffId; }

    @Override
    public String getRoleName() {
        return "AIRLINE_STAFF";
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- Airline Staff Menu ---");
        System.out.println("1. View Profile");
        System.out.println("2. View Flight Schedules (Coming Soon)");
        System.out.println("3. View Bookings (Coming Soon)");
        System.out.println("4. Logout");
    }
}
