package CityStyle_Footwear_System;

public abstract class User { // Class is an abstract class because it have an abstract method
    private final String username; // Encapsulation: Private attributes
    private final String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters (Encapsulation)
    public String getUsername() { return username; }
    
    // Abstract method (Abstraction) - Every user must have a dashboard
    public abstract void showDashboard();

    public boolean login(String uname, String pass) {
        return this.username.equals(uname) && this.password.equals(pass);
    }
}
