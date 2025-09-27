/*Description: Design a system to manage vehicle rentals:
Define an abstract class Vehicle with fields like vehicleNumber, type, and rentalRate.
Add an abstract method calculateRentalCost(int days).
Create subclasses Car, Bike, and Truck with specific implementations of calculateRentalCost().
Use an interface Insurable with methods calculateInsurance() and getInsuranceDetails().
Apply encapsulation to restrict access to sensitive details like insurance policy numbers.
Demonstrate polymorphism by iterating over a list of vehicles and calculating rental and insurance 
costs for each. */

abstract class Vehicle {
    private int vehicleNumber;
    private String type;
    private double rentalRate;
    private String policyNumbers;

    Vehicle(int vehicleNumber, String type, double rentalRate, String policyNumbers) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.policyNumbers = policyNumbers;
    }

    

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    
    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    
    public String getPolicyNumber() {
        return policyNumbers;
    }

    abstract double calculateRentalCost(int days);

    public void displayDetails(int days){
        System.out.println("----Vehicle Details----");
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Type : " + type);
        System.out.println("Rental rate : " + rentalRate);
        System.out.println("Policy Number : " + policyNumbers );
        
    }

}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private double insuranceRate = 1000;

    

    Car(int vehicleNumber, String type, double rentalRate, String policyNumbers) {
        super(vehicleNumber, type, rentalRate, policyNumbers);
        
        

    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;

    }

    public double calculateInsurance() {
        return insuranceRate;

    }

    public String getInsuranceDetails() {
        return "Car insurance policy applied ";

    }


    public void displayDetails(int days){
        super.displayDetails(days);
        System.out.println("Rental rate for " + days + " days: " + calculateRentalCost(days));
        System.out.println("Total rate after insurance " + (calculateRentalCost(days) + calculateInsurance()));
        System.out.println(getInsuranceDetails());
        System.out.println();

    }

}

class Bike extends Vehicle implements Insurable {
    private double insuranceRate = 500;
    
    

    Bike(int vehicleNumber, String type, double rentalRate, String policyNumbers) {
        super(vehicleNumber, type, rentalRate, policyNumbers);
        

    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;

    }

    public double calculateInsurance() {
        return insuranceRate;

    }

    public String getInsuranceDetails() {
        return "Bike insurance policy applied";

    }

    
    public void displayDetails(int days){
        super.displayDetails(days);
        System.out.println("Rental rate for " + days + " days " + calculateRentalCost(days));
        System.out.println("Total rate after insurance " + (calculateRentalCost(days) + calculateInsurance()));
        System.out.println(getInsuranceDetails());
        System.out.println();

    }
}

class Truck extends Vehicle implements Insurable {
    private double insuranceRate = 1600;
    
    

    Truck(int vehicleNumber, String type, double rentalRate, String policyNumbers) {
        super(vehicleNumber, type, rentalRate, policyNumbers);
       

    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;

    }

    public double calculateInsurance() {
        return insuranceRate;

    }

    public String getInsuranceDetails() {
        return "Truck insurance policy applied";

    }

    
    public void displayDetails(int days){
        super.displayDetails(days);
        System.out.println("Rental rate for " + days + " days " + calculateRentalCost(days));
        System.out.println("Total rate after insurance " + (calculateRentalCost(days) + calculateInsurance()));
        System.out.println(getInsuranceDetails());

    }

}

public class VehicleRental {
    public static void main(String[] args) {
        Vehicle c=new Car(1321, "Four wheeler", 1200, "CA-45677");
        Vehicle b=new Bike(1666,"Two wheeler", 500, "BI-73673");
        Vehicle t=new Truck(7722, "Eight wheeler", 1900, "TR-54566");

        int carDays=5;
        int bikeDays=8;
        int truckDays=12;

      c.displayDetails(carDays);
      b.displayDetails(bikeDays);
      t.displayDetails(truckDays);

    }

}
