package marketplace.main;

import marketplace.products.Category;
import marketplace.users.Customer;
import marketplace.users.Employee;

import java.util.Scanner;

public class Marketplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Category bathroom = new Category("Bathroom");
        Category kitchen = new Category("Kitchen");
        Category bedroom = new Category("Bedroom");
        Category drawingRoom = new Category("Drawing Room");
        Category homeExteriors = new Category("Home Exteriors");

        boolean continueUsing = true;

        while (continueUsing) {
            System.out.println("Welcome to the Marketplace!");
            System.out.print("Enter 1 for Employee or 2 for Customer: ");
            int userType = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (userType == 1) {
                // Employee Interface
                Employee employee = new Employee("John Doe");

                boolean manageMore = true;
                while (manageMore) {
                    System.out.print("Choose a category to manage: ");
                    System.out.println("Bathroom");
                    System.out.println("Kitchen ");
                    System.out.println("Bedroom");
                    System.out.println("Drawing room");
                    System.out.println("Home exteriors");
                    String categoryName = scanner.nextLine();

                    switch (categoryName.toLowerCase()) {
                        case "bathroom":
                            employee.manageCategory(bathroom);
                            break;
                        case "kitchen":
                            employee.manageCategory(kitchen);
                            break;
                        case "bedroom":
                            employee.manageCategory(bedroom);
                            break;
                        case "drawing room":
                            employee.manageCategory(drawingRoom);
                            break;
                        case "home exteriors":
                            employee.manageCategory(homeExteriors);
                            break;
                        default:
                            System.out.println("Invalid category selected!");
                            break;
                    }

                    System.out.println("Do you want to manage another category? (yes/no)");
                    String response = scanner.nextLine();
                    if (!response.equalsIgnoreCase("yes")) {
                        manageMore = false;
                    }
                }

            } else if (userType == 2) {
                Customer customer = new Customer("Jane Doe");

                boolean shopMore = true;
                while (shopMore) {
                    System.out.print("Choose a category to shop: ");
                    System.out.println("Bathroom");
                    System.out.println("Kitchen ");
                    System.out.println("Bedroom");
                    System.out.println("Drawing room");
                    System.out.println("Home exteriors");
                    String categoryName = scanner.nextLine();

                    switch (categoryName.toLowerCase()) {
                        case "bathroom":
                            customer.shopInCategory(bathroom);
                            break;
                        case "kitchen":
                            customer.shopInCategory(kitchen);
                            break;
                        case "bedroom":
                            customer.shopInCategory(bedroom);
                            break;
                        case "drawing room":
                            customer.shopInCategory(drawingRoom);
                            break;
                        case "home exteriors":
                            customer.shopInCategory(homeExteriors);
                            break;
                        default:
                            System.out.println("Invalid category selected!");
                            break;
                    }

                    System.out.println("Do you want to shop in another category? (yes/no)");
                    String response = scanner.nextLine();
                    if (!response.equalsIgnoreCase("yes")) {
                        shopMore = false;
                    }
                }

                System.out.println("Do you want to get your bill now? (yes/no)");
                String billResponse = scanner.nextLine();
                if (billResponse.equalsIgnoreCase("yes")) {
                    customer.getBill();
                }

            } else {
                System.out.println("Invalid user type selected!");
            }

            System.out.println("Do you want to continue using the Marketplace? (yes/no)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                continueUsing = false;
            }
        }

        System.out.println("Thank you for using the Marketplace. Goodbye!");
        scanner.close();
    }
}
