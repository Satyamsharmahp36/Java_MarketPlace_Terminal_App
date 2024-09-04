package marketplace.products;

public class Product {
    private String serialNumber;
    private String name;
    private double price;
    private int quantity;
    private String description;

    public Product(String serialNumber, String name, double price, int quantity, String description) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

     public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void updateQuantity(int additionalQuantity) {
        this.quantity += additionalQuantity;
    }

    public void displayDetails() {
        System.out.println("Product Serial Number: " + serialNumber);
        System.out.println("Product Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Available Quantity: " + quantity);
        System.out.println("Description: " + description);
    }
}
