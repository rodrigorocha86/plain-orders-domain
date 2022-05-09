package it.rocha.plain.orders.domain.product;

import java.math.BigDecimal;

public final class Product {

    private final String code;
    private String name;
    private String description;
    private BigDecimal value;

    public Product(
            String code, String name,
            String description, BigDecimal value) {
        validateCode(code);
        this.code = code;

        changeName(name);
        changeDescription(description);
        changeValue(value);
    }

    private void validateCode(String code) {
        if(code == null) {
            throw new IllegalArgumentException("Attribute code is mandatory.");
        }
    }
    public void changeName(String name) {
        if(name == null
                || name.length() <= 1
                || name.length() > 50) {
            throw new IllegalArgumentException("Invalid name: " + name);
        }
        this.name = name;
    }

    private void changeDescription(String description) {
        if(description == null
                || description.length() <= 1
                || description.length() > 250) {
            throw new IllegalArgumentException("Invalid description: " + name);
        }
        this.name = name;
    }

    private void changeValue(BigDecimal value) {
        if(value == null
                || BigDecimal.ZERO.compareTo(value) >= 0) {
            throw new IllegalArgumentException("Invalid value: " + value);

        }
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }
}
