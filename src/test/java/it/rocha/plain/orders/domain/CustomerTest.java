package it.rocha.plain.orders.domain;

import it.rocha.plain.orders.domain.customer.Cpf;
import it.rocha.plain.orders.domain.customer.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class CustomerTest {

    @Test
    public void testInvalidCustomer() {
        Throwable result = Assert.assertThrows(
                IllegalArgumentException.class,
                () -> new Customer(
                        "001",
                        new Cpf("55555555555"),
                        "R",
                        LocalDate.parse("1986-09-04")));

        Assert.assertEquals("Invalid name: R", result.getMessage());
    }

    @Test
    public void testNewValidCustomer() {
        Customer customer = new Customer(
                "001",
                new Cpf("55555555555"),
                "Rodrigo Rocha de Moraes",
                LocalDate.parse("1986-09-04"));

        Assert.assertEquals("Rodrigo Rocha de Moraes", customer.getName());
    }
}
