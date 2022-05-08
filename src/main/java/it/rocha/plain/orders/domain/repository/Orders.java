package it.rocha.plain.orders.domain.repository;

import it.rocha.plain.orders.domain.entity.Order;

import java.util.Set;

public interface Orders {

    void add(Order order);
    Set<Order> findAll();

}
