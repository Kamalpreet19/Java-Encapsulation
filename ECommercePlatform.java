/*Develop a simplified e-commerce platform:
Create an abstract class Product with fields like productId, name, and price, and an abstract 
method calculateDiscount().
Extend it into concrete classes: Electronics, Clothing, and Groceries.
Implement an interface Taxable with methods calculateTax() and getTaxDetails() for applicable 
product categories.
Use encapsulation to protect product details, allowing updates only through setter methods.
Showcase polymorphism by creating a method that calculates and prints the final price 
(price + tax - discount) for a list of Product. */

abstract class Product {
    private int productId;
    private String name;
    private double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;

    }

    public double getPrice() {
        return price;
    }

    void displayDetails() {
        System.out.println("Product Id : " + productId);
        System.out.println("Name : " + name);
        System.out.println("Price : " + price);
    }

    abstract double calculateDiscount();

    abstract double FinalPrice();

}

interface Taxable {
    double calculateTax();

    String getTaxDetails();
}

class Electronics extends Product implements Taxable {

    Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;

    }

    public double calculateTax() {
        return getPrice() * 0.05;

    }

    public String getTaxDetails() {
        return " 5 % GST on electronics ";

    }

    public double FinalPrice() {
        return getPrice() + calculateTax() - calculateDiscount();

    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Discount : " + calculateDiscount());
        System.out.println("Tax : " + calculateTax());
        System.out.println("Tax details : " + getTaxDetails());
    }

}

class Clothing extends Product implements Taxable {
    Clothing(int productId, String name, double price) {
        super(productId, name, price);

    }

    public double calculateDiscount() {
        return getPrice() * 0.5;

    }

    public double calculateTax() {
        return getPrice() * 0.18;

    }

    public String getTaxDetails() {
        return " 18 % GST on clothing ";
    }

    public double FinalPrice() {
        return getPrice() + calculateTax() - calculateDiscount();

    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Discount : " + calculateDiscount());
        System.out.println("Tax : " + calculateTax());
        System.out.println("Tax details : " + getTaxDetails());
    }

}

class Groceries extends Product implements Taxable {
    Groceries(int productId, String name, double price) {
        super(productId, name, price);

    }

    public double calculateDiscount() {
        return getPrice() * 0.5;

    }

    public double calculateTax() {
        return getPrice() * 0.20;

    }

    public String getTaxDetails() {
        return " 20% tax on groceries ";

    }

    public double FinalPrice() {
        return getPrice() + calculateTax() - calculateDiscount();

    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Discount : " + calculateDiscount());
        System.out.println("Tax : " + calculateTax());
        System.out.println("Tax details : " + getTaxDetails());
    }

}

public class ECommercePlatform {
    public static void main(String[] args) {

        Product obj1 = new Electronics(101, "Laptop", 50000);
        Product obj2 = new Clothing(102, "Shirt", 2000);
        Product obj3 = new Groceries(103, "Apples", 500);

        Product products[] = { obj1, obj2, obj3 };
        for (int i = 0; i < products.length; i++) {
            products[i].displayDetails();
            System.out.println("Final Price : " + products[i].FinalPrice());
            System.out.println("----------------------------");
        }
    }

}
