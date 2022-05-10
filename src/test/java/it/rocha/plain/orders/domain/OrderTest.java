package it.rocha.plain.orders.domain;

import it.rocha.plain.orders.domain.customer.Cpf;
import it.rocha.plain.orders.domain.customer.Customer;
import it.rocha.plain.orders.domain.order.Order;
import it.rocha.plain.orders.domain.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderTest {

    @Test
    public void testCreateNewValidOrderOneItem() {
        Order order = new Order(
                999L, "001",
                "001", BigDecimal.TEN);
        Assert.assertEquals((long) 999L, (long) order.getNumber());
        Assert.assertEquals(BigDecimal.TEN, order.getTotal());
        Assert.assertEquals(1, order.getItems().size());
    }

    @Test
    public void testCreateNewValidOrderMoreItems() {
        Order order = new Order(
                999L, "001",
                "001", BigDecimal.TEN);
        order.addItem("002", BigDecimal.TEN, 5);

        Assert.assertEquals((long) 999L, (long) order.getNumber());
        Assert.assertEquals(BigDecimal.valueOf(60L), order.getTotal());
        Assert.assertEquals(2, order.getItems().size());
    }
}