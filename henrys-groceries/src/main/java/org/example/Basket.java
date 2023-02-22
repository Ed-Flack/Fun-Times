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

    public double getTotal() {
        return products.get(0).getCost();
    }
}
