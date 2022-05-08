package it.rocha.plain.orders.domain.entity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Order {

    private final Long number;

    private final Customer customer;

    private final Set<OrderItem> items;
    private BigDecimal total;

    public Order(
            Long number, Customer customer,
            Product product) {
        validate(number, customer, product);
        this.number = number;
        this.customer = customer;
        this.items = new HashSet<>();
        addItem(1, product);
    }

    private void validate(
            Long number, Customer customer,
            Product product) {
        if(number == null) {
            throw new IllegalArgumentException("Number is mandatory.");
        }

        if(customer == null) {
            throw new IllegalArgumentException("Customer is mandatory.");
        }

        if(product == null) {
            throw new IllegalArgumentException("Product is mandatory.");
        }
    }

    private void calculateTotal() {
        this.total = items.stream()
                .map(OrderItem::getTotal)
                .reduce(BigDecimal.ZERO, (tempTotal, currTotal) -> tempTotal.add(currTotal));
    }

    public void addItem(
            Integer amount, Product product) {
        this.items.add(new OrderItem(amount, product));
        calculateTotal();
    }

    public Long getNumber() {
        return this.number;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public Set<OrderItem> getItems() {
        return Collections.unmodifiableSet(this.items);
    }
}