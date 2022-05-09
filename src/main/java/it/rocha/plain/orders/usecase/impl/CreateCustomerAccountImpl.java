package it.rocha.plain.orders.usecase.impl;

import it.rocha.plain.orders.domain.customer.Cpf;
import it.rocha.plain.orders.domain.customer.Customer;
import it.rocha.plain.orders.repository.Customers;
import it.rocha.plain.orders.usecase.CreateCustomerAccount;
import it.rocha.plain.orders.usecase.model.CustomerDto;

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