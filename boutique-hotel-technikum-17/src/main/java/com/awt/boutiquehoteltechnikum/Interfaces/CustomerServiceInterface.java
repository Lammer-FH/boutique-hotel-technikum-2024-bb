package com.awt.boutiquehoteltechnikum.Interfaces;

import com.awt.boutiquehoteltechnikum.Entities.CustomerEntity;

public interface CustomerServiceInterface {
    CustomerEntity createCustomer(CustomerEntity customerEntity);

    CustomerEntity updateCustomer(CustomerEntity customerEntity);

    CustomerEntity getCustomerById(int id);
}
