package com.awt.boutiquehoteltechnikum.Controller;

import com.awt.boutiquehoteltechnikum.DTO.CustomerDTO;
import com.awt.boutiquehoteltechnikum.Mapper.CustomerMapper;
import com.awt.boutiquehoteltechnikum.Model.Customer;
import com.awt.boutiquehoteltechnikum.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(CustomerMapper.INSTANCE.customerDTOtoCustomer(customerDTO));
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> getCustomer(@PathVariable int customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(CustomerMapper.INSTANCE.customerDTOtoCustomer(customerDTO));
    }
}
