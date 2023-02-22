import org.example.Basket;
import org.example.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void canAddProductToBasket() {
        Basket basket = new Basket();
        basket.addProduct(Product.SOUP);
        String expected = "0.65";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void canAddTwoProductsToBasket() {
        Basket basket = new Basket();
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.BREAD);
        String expected = "1.45";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void buyTwoTinsOfSoupAndGetALoafOdBreadHalfPrice() {
        Basket basket = new Basket();
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.SOUP);
        basket.addProduct(Product.BREAD);
        String expected = "1.70";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

}