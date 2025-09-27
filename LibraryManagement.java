/*Description: Develop a library management system:
Use an abstract class LibraryItem with fields like itemId, title, and author.
Add an abstract method getLoanDuration() and a concrete method getItemDetails().
Create subclasses Book, Magazine, and DVD, overriding getLoanDuration() with specific logic.
Implement an interface Reservable with methods reserveItem() and checkAvailability().
Apply encapsulation to secure details like the borrower’s personal data.
Use polymorphism to allow a general LibraryItem reference to manage all items, regardless of type. */

abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;
    private String borrowerName = "";

    LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrowerName = "";
    }

    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    abstract int getLoanDuration();

    void getItemDetails() {
        System.out.println("----Item Details----");
        System.out.println("Item Id : " + itemId);
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        
    }

}

interface Reservable {
    void reserveItem();

    boolean checkAvailability();

}

class Book extends LibraryItem implements Reservable {
    private boolean available;

    Book(int itemId, String title, String author, boolean available) {
        super(itemId, title, author);
        this.available = available;
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem() {
        if (available) {
            available = false;
            System.out.println(getTitle() + " reserved successfully ");
        } else {
            System.out.println(getTitle() + " not reserved successfully ");
        }
    }

    public boolean checkAvailability() {
        return available;
    }

    void getItemDetails() {
        super.getItemDetails();
        System.out.println("Duration : " + getLoanDuration());
        System.out.println();

    }

}

class Magazine extends LibraryItem implements Reservable {
    private boolean available;

    Magazine(int itemId, String title, String author, boolean available) {
        super(itemId, title, author);
        this.available = available;
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem() {
        if (available) {
            available = false;
            System.out.println(getTitle() + " reserved successfully ");
        } else {
            System.out.println(getTitle() + " not reserved successfully ");
        }
    }

    public boolean checkAvailability() {
        return available;
    }

    void getItemDetails() {
        super.getItemDetails();
        System.out.println("Duration : " + getLoanDuration());
        System.out.println();

    }

}

class DVD extends LibraryItem implements Reservable {
    private boolean available;

    DVD(int itemId, String title, String author, boolean available) {
        super(itemId, title, author);
        this.available = available;
    }

    public int getLoanDuration() {
        return 4;
    }

    public void reserveItem() {
        if (available) {
            available = false;
            System.out.println(getTitle() + " reserved successfully ");
        } else {
            System.out.println(getTitle() + " not reserved successfully ");
        }
    }

    public boolean checkAvailability() {
        return available;
    }

    void getItemDetails() {
        super.getItemDetails();
        System.out.println("Duration : " + getLoanDuration());
        System.out.println();

    }

}

public class LibraryManagement {
    public static void main(String args[]) {
        LibraryItem b = new Book(11, "Red Roses", "Meena Mehta", true);
        LibraryItem m = new Magazine(21, "Tea Coffee", "Reena Roy", true);
        LibraryItem d = new DVD(1, "Gup Shup", "Teena Verma", true);

        LibraryItem li[] = { b, m, d };
        for (int i = 0; i < li.length; i++) {
            li[i].getItemDetails();

        }

        System.out.println("----Reserving Items----");
        ((Reservable) li[0]).reserveItem();
        ((Reservable) li[1]).reserveItem();
        ((Reservable) li[2]).reserveItem();
        System.out.println();

        System.out.println("----Checking Availablility");
        System.out.println("Book available? " + ((Reservable) li[0]).checkAvailability());
        System.out.println("Magazine available? " + ((Reservable) li[1]).checkAvailability());
        System.out.println("DVD available? " + ((Reservable) li[2]).checkAvailability());

    }

}
