package airlinereservation.models;

public class Passenger extends User {
    private String passportNumber;
    private String mealPreference;

    public Passenger(String userId, String name, String email, String phone, String password, String dateOfBirth, String passportNumber) {
        super(userId, name, email, phone, password, dateOfBirth);
        this.passportNumber = passportNumber;
        this.mealPreference = "Standard";
    }

    public String getPassportNumber() { return passportNumber; }
    public String getMealPreference() { return mealPreference; }
    public void setMealPreference(String mealPreference) { this.mealPreference = mealPreference; }

    @Override
    public String getRoleName() {
        return "PASSENGER";
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- Passenger Menu ---");
        System.out.println("1. View Profile");
        System.out.println("2. Search Flights (Coming Soon)");
        System.out.println("3. View My Bookings (Coming Soon)");
        System.out.println("4. Logout");
    }
}
