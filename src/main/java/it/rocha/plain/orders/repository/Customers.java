package it.rocha.plain.orders.repository;

import it.rocha.plain.orders.domain.customer.Customer;

import java.util.Set;

public interface Customers {

    void add(Customer customer);
    Set<Customer> all();
}
