package CityStyle_Footwear_System;


public class Manager extends Cashier {
    private final String managerID;

    public Manager(String username, String password, String managerID) {
        super(username, password, "Manager"); // Multi-level Inheritance
        this.managerID = managerID;
    }

    @Override
    public void showDashboard() { // Overriding
        System.out.println("Loading Manager Dashboard with Inventory Controls.");
    }
    
    public void generateReport() {
        System.out.println("Generating detailed inventory report...");
    }
}
