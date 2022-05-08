package it.rocha.plain.orders.domain;

import it.rocha.plain.orders.domain.entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductTest {

    @Test
    public void testProductNameNotBetween1to50() {
        Throwable result = Assert.assertThrows(
                IllegalArgumentException.class,
                () -> new Product(
                        "001", "A",
                        "Desc", BigDecimal.TEN));
        Assert.assertEquals("Invalid name: A", result.getMessage());

        result = Assert.assertThrows(
                IllegalArgumentException.class,
                () -> new Product(
                        "001", "ABCDEFGHI_ABCDEFGHI_ABCDEFGHI_ABCDEFGHI_ABCDEFGHI_A",
                        "Desc", BigDecimal.TEN));
        Assert.assertEquals(
                "Invalid name: ABCDEFGHI_ABCDEFGHI_ABCDEFGHI_ABCDEFGHI_ABCDEFGHI_A",
                result.getMessage());

    }

    @Test
    public void testProductNameBetween1to50() {
        Product product = new Product(
                "001", "Ab",
                "Desc", BigDecimal.TEN);
        Assert.assertEquals("Ab", product.getName());

        product = new Product(
                "001", "ABCDEFGHI_ABCDEFGHI_ABCDEFGHI_ABCDEFGHI_ABCDEFGHI_",
                "Desc", BigDecimal.TEN);
        Assert.assertEquals(
                "ABCDEFGHI_ABCDEFGHI_ABCDEFGHI_ABCDEFGHI_ABCDEFGHI_",
                product.getName());
    }

    @Test
    public void testProductValueNotGreaterThanZero() {
        Throwable result = Assert.assertThrows(
                IllegalArgumentException.class,
                () -> new Product(
                        "001", "ABC",
                        "Desc", BigDecimal.valueOf(-1)));
        Assert.assertEquals("Invalid value: -1", result.getMessage());
    }

    @Test
    public void testProductValueEqualToZero() {
        Throwable result = Assert.assertThrows(
                IllegalArgumentException.class,
                () -> new Product(
                        "001", "ABC",
                        "Desc", BigDecimal.ZERO));
        Assert.assertEquals("Invalid value: 0", result.getMessage());
    }

    @Test
    public void testProductValueGreaterThanZero() {
        Product product = new Product(
                "001", "ABC",
                "Desc", BigDecimal.TEN);
        Assert.assertEquals(BigDecimal.TEN, product.getValue());
    }
}
