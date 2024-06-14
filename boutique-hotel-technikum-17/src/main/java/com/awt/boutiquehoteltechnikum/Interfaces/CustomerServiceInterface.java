package com.awt.boutiquehoteltechnikum.Interfaces;

import com.awt.boutiquehoteltechnikum.Entities.Customer;

public interface CustomerServiceInterface {
    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer getCustomerById(int id);
}
