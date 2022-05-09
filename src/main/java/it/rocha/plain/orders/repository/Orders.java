package it.rocha.plain.orders.repository;

import it.rocha.plain.orders.domain.order.Order;

import java.util.Set;

public interface Orders {

    void add(Order order);
    Set<Order> findAll();

}
