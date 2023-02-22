package org.example;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Product> products;

    public Basket() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public String getTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getCost();
        }
        return String.format("%.2f", total);
    }
}
