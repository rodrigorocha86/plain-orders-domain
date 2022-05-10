package it.rocha.plain.orders.usecase.impl;

import it.rocha.plain.orders.usecase.CustomerCodeGenerator;

import javax.inject.Named;
import java.util.UUID;

@Named
public class UuidCustomerCodeGeneratorImpl
        implements CustomerCodeGenerator {

    @Override
    public String run() {
        return UUID.randomUUID().toString();
    }
}