package it.rocha.plain.orders.usecase.impl;

import it.rocha.plain.orders.usecase.model.CustomerDto;
import it.rocha.plain.orders.usecase.CreateCustomerAccount;
import it.rocha.plain.orders.domain.entity.Cpf;
import it.rocha.plain.orders.domain.entity.Customer;
import it.rocha.plain.orders.domain.repository.Customers;

import javax.inject.Named;

@Named
public class CreateCustomerAccountImpl
        implements CreateCustomerAccount {

    private Customers customers;

    public CreateCustomerAccountImpl(Customers customers) {
        this.customers = customers;
    }

    @Override
    public void run(CustomerDto customerDto) {
        Customer customer = new Customer(
                new Cpf(customerDto.getCpf()),
                customerDto.getName(),
                customerDto.getBirthdate()
        );
        customers.add(customer);
    }
}