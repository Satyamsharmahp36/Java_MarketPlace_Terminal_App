package marketplace.users;

import marketplace.products.Category;
import marketplace.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private String name;
    private List<Product> cart;

    public Customer(String name) {
        this.name = name;
        this.cart = new ArrayList<>();
    }

    public void shopInCategory(Category category) {
        Scanner scanner = new Scanner(System.in);
        boolean continueShopping = true;

        while (continueShopping) {
            System.out.println("Browsing category: " + category.getName());
            category.displayProducts();

            System.out.print("Enter the Serial Number of the Product to Purchase: ");
            String serialNumber = scanner.nextLine();
            Product product = category.findProductBySerialNumber(serialNumber);

            if (product != null) {
                System.out.print("Enter Quantity to Purchase: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                if (quantity <= product.getQuantity()) {
                    product.updateQuantity(-quantity);
                    cart.add(new Product(serialNumber, product.getName(), product.getPrice(), quantity, product.getDescription()));
                    System.out.println("Product added to cart!");
                } else {
                    System.out.println("Insufficient quantity available!");
                }
            } else {
                System.out.println("Product not found!");
            }

            System.out.println("Do you want to continue shopping in this category? (yes/no)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                continueShopping = false;
            }
        }

        // Show Cart and Checkout
        displayCart();
    }

    private void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your Cart:");
            double totalCost = 0;
            for (Product product : cart) {
                product.displayDetails();
                System.out.println("Quantity: " + product.getQuantity());
                totalCost += product.getPrice() * product.getQuantity();
                System.out.println("-----------------------------");
            }
            System.out.println("Total Cost: $" + totalCost);
        }
    }

    public void getBill() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. No items to bill.");
        } else {
            System.out.println("Billing Details:");
            double totalCost = 0;
            for (Product product : cart) {
                System.out.println(product.getName() + " - Quantity: " + product.getQuantity() + ", Price per unit: $" + product.getPrice());
                totalCost += product.getPrice() * product.getQuantity();
            }
            System.out.println("Total Amount Due: $" + totalCost);
            cart.clear();
            System.out.println("Thank you for your purchase!");
        }
    }
}
