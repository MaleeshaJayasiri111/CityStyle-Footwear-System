package CityStyle_Footwear_System;


public class Cashier extends User {
    private final String cashierID;

    public Cashier(String username, String password, String cashierID) {
        super(username, password, "Cashier"); // Inheritance
        this.cashierID = cashierID;
    }

    @Override
    public void showDashboard() { // Method Overriding
        System.out.println("Loading Cashier Dashboard for: " + getUsername());
    }

    // Method Overloading (Polymorphism)
    public void searchShoe(String modelName) {
        System.out.println("Searching for model: " + modelName);
    }
    
    public void searchShoe(int shoeID) {
        System.out.println("Searching for Shoe ID: " + shoeID);
    }
}
