import org.example.Basket;
import org.example.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BasketTest {

    @Test
    public void canAddProductToBasket() {
        Basket basket = new Basket(LocalDate.now());
        basket.addProduct(Product.SOUP);
        String expected = "0.65";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void canAddTwoProductsToBasket() {
        Basket basket = new Basket(LocalDate.now());
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.BREAD);
        String expected = "1.45";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void buyTwoTinsOfSoupAndGetALoafOfBreadHalfPrice() {
        Basket basket = new Basket(LocalDate.now());
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.BREAD);
        String expected = "1.70";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void buyTwoTinsOfSoupAndGetALoafOfBreadHalfPriceBeforeOfferStartDate() {
        Basket basket = new Basket(LocalDate.now().minusDays(2));
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.BREAD);
        String expected = "2.10";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void buyTwoTinsOfSoupAndGetALoafOfBreadHalfPriceAfterOfferEndDate() {
        Basket basket = new Basket(LocalDate.now().plusDays(7));
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.BREAD);
        String expected = "2.10";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void appleHasTenPercentDiscount() {
        Basket basket = new Basket(LocalDate.now());
        basket.addProduct(Product.APPLE);
        String expected = "0.09";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

}