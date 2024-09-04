package marketplace.users;

import marketplace.products.Category;
import marketplace.products.Product;

import java.util.Scanner;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void manageCategory(Category category) {
        Scanner scanner = new Scanner(System.in);
        boolean continueManaging = true;

        while (continueManaging) {
            System.out.println("Managing category: " + category.getName());

            System.out.println("Enter 1 to Add New Product or 2 to Update Existing Product:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                // Add new product
                System.out.print("Enter Product Serial Number: ");
                String serialNumber = scanner.nextLine();
                System.out.print("Enter Product Name: ");
                String productName = scanner.nextLine();
                System.out.print("Enter Product Price: ");
                double price = scanner.nextDouble();
                System.out.print("Enter Product Quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter Product Description: ");
                String description = scanner.nextLine();

                Product product = new Product(serialNumber, productName, price, quantity, description);
                category.addProduct(product);
                System.out.println("Product added successfully!");

            } else if (choice == 2) {
                // Update existing product
                System.out.print("Enter Product Serial Number to Update: ");
                String serialNumber = scanner.nextLine();
                Product product = category.findProductBySerialNumber(serialNumber);

                if (product != null) {
                    System.out.print("Enter Quantity to Add: ");
                    int additionalQuantity = scanner.nextInt();
                    product.updateQuantity(additionalQuantity);
                    System.out.println("Product quantity updated successfully!");
                } else {
                    System.out.println("Product not found!");
                }
            } else {
                System.out.println("Invalid choice!");
            }

            System.out.println("Do you want to continue managing this category? (yes/no)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                continueManaging = false;
            }
        }
    }
}
