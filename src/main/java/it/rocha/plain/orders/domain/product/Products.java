package it.rocha.plain.orders.domain.product;

import it.rocha.plain.orders.domain.product.Product;

import java.util.Set;

public interface Products {

    void create(Product product);
    void update(Product product);
    Set<Product> all();

}
