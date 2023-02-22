package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Welcome to Henry's Groceries!");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        LocalDate date = getDateOfPurchase(scanner, dateFormatter);
        System.out.println("Great! You have chosen " + date.format(dateFormatter) + " as your date of purchase!");
        Basket basket = chooseProducts(scanner, date);
        System.out.println("Your total is: " + basket.getTotal());
    }

    private static LocalDate getDateOfPurchase(Scanner scanner, DateTimeFormatter dateFormatter) {
        boolean dateIsValid = false;
        LocalDate localDate = null;
        do {
            System.out.println("What day would you like to purchase from us?");
            System.out.println("Please enter as in the format 'dd/mm/yyyy'");
            try {
                String date = scanner.nextLine();
                localDate = LocalDate.parse(date, dateFormatter);
                dateIsValid = true;
            } catch (DateTimeParseException ignored) {
            }
        } while (!dateIsValid);
        return localDate;
    }

    private static Basket chooseProducts(Scanner scanner, LocalDate date) {
        String input;
        Basket basket = new Basket(date);
        do {
            System.out.println("Please choose what products you would like to purchase:");
            int i = 1;
            for (Product product : Product.values()) {
                System.out.printf("%d) %s %.2f%n", i, product.getName(), product.getCost());
                i++;
            }
            System.out.println(i + ") " + "Done");
            input = scanner.nextLine();
            if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")) {
                Product product = Product.values()[Integer.parseInt(input) - 1];
                basket.addProduct(product);
                System.out.println("You added a " + product.getUnit() + " of " + product.getName() + "!");
            }
        } while (!input.equals("5"));
        return basket;
    }
}
