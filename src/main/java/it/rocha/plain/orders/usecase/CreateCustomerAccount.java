package it.rocha.plain.orders.usecase;

import it.rocha.plain.orders.usecase.model.CustomerDto;

public interface CreateCustomerAccount {

    void run(CustomerDto customerDto);

}
