package it.rocha.plain.orders.usecase.impl;

import it.rocha.plain.orders.domain.customer.Cpf;
import it.rocha.plain.orders.domain.customer.Customer;
import it.rocha.plain.orders.usecase.CustomerCodeGenerator;
import it.rocha.plain.orders.domain.customer.Customers;
import it.rocha.plain.orders.usecase.CreateCustomerAccount;
import it.rocha.plain.orders.usecase.model.CustomerDto;

import javax.inject.Named;

@Named
public class CreateCustomerAccountImpl
        implements CreateCustomerAccount {

    private Customers customers;
    private CustomerCodeGenerator customerCodeGenerator;

    public CreateCustomerAccountImpl(Customers customers, CustomerCodeGenerator customerCodeGenerator) {
        this.customers = customers;
        this.customerCodeGenerator = customerCodeGenerator;
    }

    @Override
    public void run(CustomerDto customerDto) {
        Customer customer = new Customer(
                customerCodeGenerator.run(),
                new Cpf(customerDto.getCpf()),
                customerDto.getName(),
                customerDto.getBirthdate()
        );
        customers.create(customer);
    }
}