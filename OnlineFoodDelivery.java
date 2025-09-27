/*Description: Create an online food delivery system:
Define an abstract class FoodItem with fields like itemName, price, and quantity.
Add abstract methods calculateTotalPrice() and concrete methods like getItemDetails().
Extend it into classes VegItem and NonVegItem, overriding calculateTotalPrice() to include 
additional charges (e.g., for non-veg items).
Use an interface Discountable with methods applyDiscount() and getDiscountDetails().
Demonstrate encapsulation to restrict modifications to order details and use polymorphism to 
handle different types of food items in a single order-processing method. */

abstract class FoodItem{
    private String itemName;
    private double price;
    private int quantity;

    FoodItem(String itemName, double price, int quantity){
        this.itemName=itemName;
        this.price=price;
        this.quantity=quantity;
    }
   
    public String getName(){
        return itemName;
    }

   
    public double getPrice(){
        return price;
    }



    public int getQuantity(){
        return quantity;
    }

    abstract double calculateTotalPrice();

    void getItemDetails(){
        System.out.println("----Item Details----");
        System.out.println("Name  : " + itemName);
        System.out.println("Price : " + price);
        System.out.println("Quantity : " + quantity);


    }
}
interface Discountable{
    double applyDiscount();
    String getDiscountDetails();
}
class VegItem extends FoodItem implements Discountable{
    private double discountRate;
    VegItem(String name, double price, int quantity, double discountRate){
        super(name, price, quantity);
        this.discountRate=discountRate;
    }

    public double calculateTotalPrice(){
        double total=getPrice()*getQuantity();
        return total-applyDiscount();
        

    }

    public double applyDiscount(){
        return getPrice()*getQuantity()*(discountRate/100);

    }

    public String getDiscountDetails(){
        return "Veg item discount applied : " + discountRate + " % ";

    
}

public void getItemDetails(){
    super.getItemDetails();
    System.out.println(getDiscountDetails());
    System.out.println("Total price after discount : " + calculateTotalPrice());
    System.out.println();
}
}

class NonVegItem extends FoodItem implements Discountable{
    private double extraCharge;
    private double discountRate;
    NonVegItem(String name, double price, int quantity,double extraCharge,double discountRate){
        super(name, price, quantity);
        this.extraCharge=extraCharge;
        this.discountRate=discountRate;
    }

    public double calculateTotalPrice(){
        double total = (getPrice() + extraCharge) * getQuantity();
        return total - applyDiscount();

    }

    public double applyDiscount(){
         return (getPrice() + extraCharge) * getQuantity() * (discountRate / 100);

    }

    public String getDiscountDetails(){
        return "Non-Veg item discount applied: " + discountRate + "% (Extra charge included: " + extraCharge + ")";
    }

     public void getItemDetails() {
        super.getItemDetails();
        System.out.println(getDiscountDetails());
        System.out.println("Total Price after discount: " + calculateTotalPrice());
        
    }

    }

public class OnlineFoodDelivery {
    public static void main(String[] args) {
       
        FoodItem vegItem = new VegItem("Paneer Pizza", 250, 2, 10);       
        FoodItem nonVegItem = new NonVegItem("Chicken Burger", 150, 3, 20, 5); 

        vegItem.getItemDetails();        
        nonVegItem.getItemDetails();    
    }
}

        
