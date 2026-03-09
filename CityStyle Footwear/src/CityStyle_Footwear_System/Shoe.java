package CityStyle_Footwear_System;


public class Shoe {
    private String shoeID;  // Encapsulation (Private attributes)
    private double price;
    private int stockQuantity;

    public void setPrice(double price) {  // Encapsulation (Setter)
        if(price > 0) { // Data Validation
            this.price = price;
        } else {
            System.out.println("Invalid Price!");
        }
    }
    
    public double getPrice() { return price; }  // Encapsulation (Getter)
}
