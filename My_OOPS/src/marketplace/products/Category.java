package marketplace.products;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Product> products;

    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findProductBySerialNumber(String serialNumber) {
        for (Product product : products) {
            if (product.getSerialNumber().equals(serialNumber)) {
                return product;
            }
        }
        return null;
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available in this category.");
        } else {
            for (Product product : products) {
                product.displayDetails();
                System.out.println("-----------------------------");
            }
        }
    }
}
