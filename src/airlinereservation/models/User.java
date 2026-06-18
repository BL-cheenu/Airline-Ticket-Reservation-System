package airlinereservation.models;

public abstract class User {
    protected String userId;
    protected String name;
    protected String email;
    protected String phone;
    protected String password;
    protected String dateOfBirth;

    public User(String userId, String name, String email, String phone, String password, String dateOfBirth) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPassword() { return password; }
    public String getDateOfBirth() { return dateOfBirth; }

    public abstract String getRoleName();
    public abstract void displayMenu();

    @Override
    public String toString() {
        return String.format("[%s] ID: %s | Name: %s | Email: %s", getRoleName(), userId, name, email);
    }
}
