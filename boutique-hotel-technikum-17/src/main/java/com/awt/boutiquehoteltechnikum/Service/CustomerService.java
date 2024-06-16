package com.awt.boutiquehoteltechnikum.Service;

import com.awt.boutiquehoteltechnikum.DomainModels.CreateCustomerCommand;
import com.awt.boutiquehoteltechnikum.Entities.CustomerEntity;
import com.awt.boutiquehoteltechnikum.Mapper.CustomerMapper;
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
    public CustomerEntity createCustomer(CreateCustomerCommand createCustomerCommand) {
        return customerRepository.save(CustomerMapper.INSTANCE.customerRequestDTOtoCustomerEntity(createCustomerCommand));
    }

    @Override
    public CustomerEntity updateCustomer(CustomerEntity customerEntity) {
        Optional<CustomerEntity> customerOptional = customerRepository.findById(customerEntity.getId());
        //if(customerOptional.isPresent()){
            CustomerEntity existingCustomerEntity = customerOptional.get();
            existingCustomerEntity.setName(customerEntity.getName());
            existingCustomerEntity.setSurname(customerEntity.getSurname());
            existingCustomerEntity.setEmail(customerEntity.getEmail());
            existingCustomerEntity.setPhonenumber(customerEntity.getPhonenumber());
            existingCustomerEntity.setAddress(customerEntity.getAddress());
            return customerRepository.save(existingCustomerEntity);
       //}
    }

    @Override
    public CustomerEntity getCustomerById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"customerId not found"));
    }
}
