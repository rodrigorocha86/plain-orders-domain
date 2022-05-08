package it.rocha.plain.orders.domain.repository;

import com.sun.source.doctree.SeeTree;
import it.rocha.plain.orders.domain.entity.Product;

import java.util.Set;

public interface Products {

    void add(Product product);
    Set<Product> findAll();

}
