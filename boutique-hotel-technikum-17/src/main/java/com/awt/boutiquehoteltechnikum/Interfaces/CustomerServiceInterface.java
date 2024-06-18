package com.awt.boutiquehoteltechnikum.Interfaces;

import com.awt.boutiquehoteltechnikum.DomainModels.CreateCustomerCommand;
import com.awt.boutiquehoteltechnikum.Entities.CustomerEntity;

public interface CustomerServiceInterface {
    CustomerEntity createCustomer(CreateCustomerCommand createCustomerCommand);

    CustomerEntity updateCustomer(CustomerEntity customerEntity);

    CustomerEntity getCustomerById(int id);
}
