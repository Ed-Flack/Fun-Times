package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> products;
    private LocalDate timeOfPurchase;

    public Basket(LocalDate timeOfPurchase) {
        this.timeOfPurchase = timeOfPurchase;
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public String getTotal() {
        double total = 0;
        int noOfSoup = 0;
        int noOfBread = 0;
        for (Product product : products) {
            if (product == Product.SOUP) {
                noOfSoup++;
            } else if (product == Product.BREAD) {
                noOfBread++;
            }
            total += product.getCost();
        }
        double discount = 0;
        for (; noOfBread > 0; noOfBread--) {
            if (noOfSoup >= 2) {
                discount += Product.BREAD.getCost() / 2;
                noOfSoup -= 2;
            } else {
                break;
            }
        }
        total -= discount;
        return String.format("%.2f", total);
    }
}