package it.rocha.plain.orders.domain.order;

import it.rocha.plain.orders.domain.product.Product;

import java.math.BigDecimal;

public final class OrderItem {

    private final String productCode;
    private  BigDecimal productValue;
    private Integer amount;

    OrderItem(
            String productCode, BigDecimal productValue,
            Integer amount) {
        validateProduct(productCode, productValue);
        this.productCode = productCode;
        this.productValue = productValue;

        changeAmount(amount);
    }

    private void validateProduct(String productCode, BigDecimal productValue) {
        if(productCode == null) {
            throw new IllegalArgumentException("ProductCode is mandatory");
        }
        if(productValue == null) {
            throw new IllegalArgumentException("ProductCode is mandatory");
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
        return productValue.multiply(BigDecimal.valueOf(amount));
    }
}