package io.github.upixelar.business;

import io.github.upixelar.model.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager{

    private final CustomerValidation customerValidation;

    public StarbucksCustomerManager(CustomerValidation _customerValidation){
        customerValidation = _customerValidation;
    }

    @Override
    public void save(Customer customer) {
        if(customerValidation.validateCustomer(customer)){
            addStar(customer);
            super.save(customer);
        }

    }

    public void addStar(Customer customer){
        System.out.println("Star added to customer");
    }
}
