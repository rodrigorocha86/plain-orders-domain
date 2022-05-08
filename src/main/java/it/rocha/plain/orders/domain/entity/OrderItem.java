package it.rocha.plain.orders.domain.entity;

import java.math.BigDecimal;

public final class OrderItem {

    private Integer amount;
    private final Product product;

    public OrderItem(Integer amount, Product product) {
        changeAmount(amount);
        validateProduct(product);
        this.product = product;
    }

    private void validateProduct(Product product) {
        if(product == null) {
            throw new IllegalArgumentException("Product is mandatory");
        }
    }

    protected void changeAmount(Integer amount) {
        if(amount == null
                || amount < 0) {
            throw new IllegalArgumentException("Invalid amount: " + amount);
        }
        this.amount = amount;
    }

    public BigDecimal getTotal() {
        return product.getValue().multiply(BigDecimal.valueOf(amount));
    }
}