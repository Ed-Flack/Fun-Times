package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<Product> products;
    private final boolean soupAndBreadOfferIsRunning;
    private final boolean applesHaveDiscount;

    public Basket(LocalDate timeOfPurchase) {
        soupAndBreadOfferIsRunning = timeOfPurchase.isAfter(LocalDate.now().minusDays(1))
                && timeOfPurchase.isBefore(LocalDate.now().plusDays(6));
        applesHaveDiscount = timeOfPurchase.isAfter(LocalDate.now().plusDays(3))
                && timeOfPurchase.isBefore(LocalDate.now().plusMonths(1));
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public String getTotal() {
        double total = 0;
        int noOfSoup = 0;
        int noOfBread = 0;
        int noOfApples = 0;
        for (Product product : products) {
            if (product == Product.SOUP) {
                noOfSoup++;
            } else if (product == Product.BREAD) {
                noOfBread++;
            } else if (product == Product.APPLE) {
                noOfApples++;
            }
            total += product.getCost();
        }
        double discount = 0;
        if (soupAndBreadOfferIsRunning) {
            for (; noOfBread > 0; noOfBread--) {
                if (noOfSoup >= 2) {
                    discount += Product.BREAD.getCost() / 2;
                    noOfSoup -= 2;
                } else {
                    break;
                }
            }
        }
        if (applesHaveDiscount) {
            for (; noOfApples > 0; noOfApples--) {
                discount += Product.APPLE.getCost() / 10;
            }
        }
        total -= discount;
        return String.format("%.2f", total);
    }
}