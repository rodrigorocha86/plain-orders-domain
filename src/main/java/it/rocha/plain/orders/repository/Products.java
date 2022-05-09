package it.rocha.plain.orders.repository;

import it.rocha.plain.orders.domain.product.Product;

import java.util.Set;

public interface Products {

    void add(Product product);
    Set<Product> findAll();

}
