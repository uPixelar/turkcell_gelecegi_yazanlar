package io.github.upixelar.business;

import io.github.upixelar.model.Customer;

public class CustomerValidationManager implements CustomerValidation {

    @Override
    public boolean validateCustomer(Customer customer) {
        return false;
    }
}
