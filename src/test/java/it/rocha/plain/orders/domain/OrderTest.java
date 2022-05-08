package it.rocha.plain.orders.domain;

import it.rocha.plain.orders.domain.entity.Cpf;
import it.rocha.plain.orders.domain.entity.Customer;
import it.rocha.plain.orders.domain.entity.Order;
import it.rocha.plain.orders.domain.entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderTest {

    @Test
    public void testCreateNewValidOrderOneItem() {
        Order order = new Order(
                999L,
                createCustomer(),
                new Product(
                        "001", "S20",
                        "Smartphone Samsung", BigDecimal.TEN));

        Assert.assertEquals((long) 999L, (long) order.getNumber());
        Assert.assertEquals(BigDecimal.TEN, order.getTotal());
        Assert.assertEquals(1, order.getItems().size());
    }

    @Test
    public void testCreateNewValidOrderMoreItems() {
        Order order = new Order(
                999L,
                createCustomer(),
                new Product(
                        "001", "S20",
                        "Smartphone Samsung", BigDecimal.TEN));

        order.addItem(5,
                new Product(
                "002", "S22",
                "Smartphone Samsung", BigDecimal.TEN));

        Assert.assertEquals((long) 999L, (long) order.getNumber());
        Assert.assertEquals(BigDecimal.valueOf(60L), order.getTotal());
        Assert.assertEquals(2, order.getItems().size());
    }

    private Customer createCustomer() {
        return new Customer(
                new Cpf("55555555555"),
                "Fulano Silva",
                LocalDate.parse("1980-01-01"));
    }
}