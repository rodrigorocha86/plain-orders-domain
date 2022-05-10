package it.rocha.plain.orders.domain.order;

import it.rocha.plain.orders.domain.customer.Cpf;
import it.rocha.plain.orders.domain.customer.Customer;
import it.rocha.plain.orders.domain.product.Product;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Order {

    private final Long number;
    private final String customerCode;
    private final Set<OrderItem> items;
    private BigDecimal total;

    public Order(
            Long number, String customerCode,
            String productCode, BigDecimal productValue) {
        validate(number, customerCode, productCode, productValue);
        this.number = number;
        this.customerCode = customerCode;
        this.items = new HashSet<>();
        addItem(productCode, productValue, 1);
    }

    private void validate(
            Long number, String customerCode,
            String productCode, BigDecimal productValue) {
        if(number == null) {
            throw new IllegalArgumentException("Number is mandatory.");
        }

        if(customerCode == null) {
            throw new IllegalArgumentException("CustomerCode is mandatory.");
        }

        if(productCode == null) {
            throw new IllegalArgumentException("ProductCode is mandatory.");
        }

        if(productValue == null) {
            throw new IllegalArgumentException("ProductValue is mandatory.");
        }
    }

    private void calculateTotal() {
        this.total = items.stream()
                .map(OrderItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addItem(
            String productCode, BigDecimal productValue,
            Integer amount) {
        this.items.add(new OrderItem(productCode, productValue, amount));
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