package it.rocha.plain.orders.domain.order;

import it.rocha.plain.orders.domain.customer.Customer;
import it.rocha.plain.orders.domain.order.Order;

import java.util.Set;

public interface Orders {

    void create(Order order);
    void update(Order order);
    Set<Order> all();

}
