package it.rocha.plain.orders.domain.product;

import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class ProductService {

    private final Products products;

    public ProductService(Products products) {
        this.products = products;
    }

    public void increaseValueOfAllProductsBy(final BigDecimal percentageIncrease) {
         products.all()
                 .forEach(product -> {
                     product.increaseValueBy(percentageIncrease);
                     products.update(product);
                 });
    }
}