import org.example.Basket;
import org.example.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void canAddProductToBasket() {
        Basket basket = new Basket();
        Product product = new Product("soup", "tin", 0.65);
        basket.addProduct(product);
        String expected = "0.65";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void canAddTwoProductsToBasket() {
        Basket basket = new Basket();
        basket.addProduct(new Product("soup", "tin", 0.65));
        basket.addProduct(new Product("bread", "loaf", 0.80));
        String expected = "1.45";
        String actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

}
