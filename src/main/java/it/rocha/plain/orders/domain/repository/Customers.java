package it.rocha.plain.orders.domain.repository;

import it.rocha.plain.orders.domain.entity.Customer;
import it.rocha.plain.orders.domain.entity.Product;

import java.util.Set;

public interface Customers {

    void add(Customer customer);
    Set<Customer> all();
}
