package com.awt.boutiquehoteltechnikum.Service;

import com.awt.boutiquehoteltechnikum.Entities.Customer;
import com.awt.boutiquehoteltechnikum.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CustomerService implements com.awt.boutiquehoteltechnikum.Interfaces.CustomerServiceInterface {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findById(customer.getId());
        //if(customerOptional.isPresent()){
            Customer existingCustomer = customerOptional.get();
            existingCustomer.setName(customer.getName());
            existingCustomer.setSurname(customer.getSurname());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPhonenumber(customer.getPhonenumber());
            existingCustomer.setAddress(customer.getAddress());
            return customerRepository.save(existingCustomer);
       //}
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"customerId not found"));
    }
}
