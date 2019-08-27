package org.katas.refactoring;

public class LineItem {
    private String description;
    private double price;
    private int quantity;
    static final double Tax = .10;
    

    public LineItem(String description, double price, int quantity) {
        super();
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double totalAmount() {
        return price * quantity;
    }
    double salesTax() {
    	return totalAmount() * Tax;
    }

}