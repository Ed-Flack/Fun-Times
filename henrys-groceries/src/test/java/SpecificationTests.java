import org.example.Basket;
import org.example.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SpecificationTests {

    // Price a basket containing: 3 tins of soup and 2 loaves of bread, bought today
    // Expected total cost = 3.15
    @Test
    public void test3TinsOfSoupAnd2LoavesOfBreadToday() {
        Basket basket = new Basket(LocalDate.now());
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.BREAD);
        basket.addProduct(Product.BREAD);
        String expected = "3.15";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

    // Price a basket containing: 6 apples and a bottle of milk, bought today
    // Expected total cost = 1.90
    @Test
    public void test6ApplesAndABottleOfMilkToday() {
        Basket basket = new Basket(LocalDate.now());
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.MILK);
        String expected = "1.90";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

    // Price a basket containing: 6 apples and a bottle of milk, bought in 5 days time
    // Expected total cost = 1.84
    @Test
    public void test6ApplesAndABottleOfMilkIn5Days() {
        Basket basket = new Basket(LocalDate.now().plusDays(5));
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.MILK);
        String expected = "1.84";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

    // Price a basket containing: 3 apples, 2 tins of soup and a loaf of bread, bought in 5 days time
    // Expected total cost = 1.97
    @Test
    public void test3ApplesAnd2TinsOfSoupAndALoafOfBreadIn5Days() {
        Basket basket = new Basket(LocalDate.now().plusDays(5));
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.BREAD);
        String expected = "1.97";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }
}
