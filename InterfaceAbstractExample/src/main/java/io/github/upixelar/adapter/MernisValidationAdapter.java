package io.github.upixelar.adapter;

import io.github.upixelar.business.CustomerValidation;
import io.github.upixelar.model.Customer;
import io.github.upixelar.util.KPSPublicService;

public class MernisValidationAdapter implements CustomerValidation {
    KPSPublicService kpsPublicService = new KPSPublicService();
    @Override
    public boolean validateCustomer(Customer customer) {
        return kpsPublicService.validate(customer.getNationalId(), customer.getFirstName(), customer.getLastName(), customer.getBirthYear());
    }
}
