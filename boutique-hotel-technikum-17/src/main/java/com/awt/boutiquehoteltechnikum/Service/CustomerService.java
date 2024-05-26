package com.awt.boutiquehoteltechnikum.Service;

import com.awt.boutiquehoteltechnikum.Model.Customer;
import com.awt.boutiquehoteltechnikum.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findById(customer.getId());
        //if(customerOptional.isPresent()){
            Customer existingCustomer = customerOptional.get();
            existingCustomer.setName(customer.getName());
            existingCustomer.setAddress(customer.getAddress());
            return customerRepository.save(existingCustomer);
       //}
    }

    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }
}
