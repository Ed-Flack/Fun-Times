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
        double expected = 0.65;
        double actual = basket.getTotal();
        Assertions.assertEquals(expected, actual);
    }

}
