package io.github.upixelar;

import io.github.upixelar.adapter.MernisValidationAdapter;
import io.github.upixelar.business.NeroCustomerManager;
import io.github.upixelar.business.StarbucksCustomerManager;
import io.github.upixelar.model.Customer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        StarbucksCustomerManager starbucksCustomerManager = new StarbucksCustomerManager(new MernisValidationAdapter());
        NeroCustomerManager neroCustomerManager = new NeroCustomerManager();

        Customer omer = new Customer("12345678901", "Ömer", "Çidem", 2001);

        starbucksCustomerManager.save(omer);
        neroCustomerManager.save(omer);
    }
}