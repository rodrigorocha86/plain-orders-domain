package it.rocha.plain.orders.domain.customer;

import it.rocha.plain.orders.domain.customer.Customer;

import java.util.Set;

public interface Customers {

    void create(Customer customer);
    void update(Customer customer);
    Customer get(String code);
    Set<Customer> all();
}
