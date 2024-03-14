package io.github.upixelar.business;

import io.github.upixelar.model.Customer;

public class BaseCustomerManager implements CustomerManager {

    @Override
    public void save(Customer customer) {
        System.out.println(
                String.format("Customer '%s %s' saved to database",
                        customer.getFirstName(), customer.getLastName()
                )
        );
    }
}
